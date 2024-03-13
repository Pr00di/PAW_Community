package com.pawcommunity.main

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.pawcommunity.map.MapActivity
import com.pawcommunity.subcription.PremiumActivity
import com.pawcommunity.R
import com.pawcommunity.settings.SettingsActivity
import com.pawcommunity.animals.AnimalsActivity
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.common.api.ResolvableApiException

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() , View.OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisation des boutons

        val btnMap = findViewById<Button>(R.id.btn_map)
        btnMap.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this ,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            )
            {
                // Si les permissions ne sont pas accordées, demandez-les
                ActivityCompat.requestPermissions(
                    this ,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION) ,
                    REQUEST_LOCATION_PERMISSION
                )
            } else
            {
                // Si les permissions sont déjà accordées, lancez MapActivity
                launchMapActivity()
            }
        }

        val btnPremium = findViewById<Button>(R.id.btn_premium)
        btnPremium.setOnClickListener {
            val intent = Intent(this , PremiumActivity::class.java)
            startActivity(intent)
        }

        val btnAnimals = findViewById<Button>(R.id.btn_animals)
        btnAnimals.setOnClickListener {
            val intent = Intent(this , AnimalsActivity::class.java)
            startActivity(intent)
        }

        val btnSetting = findViewById<Button>(R.id.btn_settings)
        btnSetting.setOnClickListener {
            val intent = Intent(this , SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(p0: View?)
    {
        TODO("Not yet implemented")
    }

    private fun launchMapActivity()
    {
        if (ContextCompat.checkSelfPermission(
                this ,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        )
        {
            ActivityCompat.requestPermissions(
                this ,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION) ,
                REQUEST_LOCATION_PERMISSION
            )
        } else
        {
            checkLocationSettingsAndProceed()
        }
    }

    private fun checkLocationSettingsAndProceed()
    {
        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
        val client = LocationServices.getSettingsClient(this)
        val task = client.checkLocationSettings(builder.build())

        task.addOnSuccessListener {
            // Les paramètres de localisation sont satisfaits, démarrer MapActivity directement
            startActivity(Intent(this , MapActivity::class.java))
        }

        task.addOnFailureListener { exception ->
            if (exception is ResolvableApiException)
            {
                try
                {
                    exception.startResolutionForResult(this , REQUEST_CHECK_SETTINGS)
                } catch (sendEx: IntentSender.SendIntentException)
                {
                    Toast.makeText(
                        this ,
                        "Erreur lors de la tentative de configuration des paramètres de localisation." ,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int ,
        permissions: Array<out String> ,
        grantResults: IntArray
    )
    {
        super.onRequestPermissionsResult(requestCode , permissions , grantResults)
        if (requestCode == REQUEST_LOCATION_PERMISSION)
        {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                checkLocationSettingsAndProceed()
            } else
            {
                Toast.makeText(this , "Permission de localisation refusée" , Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int , resultCode: Int , data: Intent?)
    {
        super.onActivityResult(requestCode , resultCode , data)
        if (requestCode == REQUEST_CHECK_SETTINGS)
        {
            if (resultCode == RESULT_OK)
            {
                startActivity(Intent(this , MapActivity::class.java))
            } else
            {
                Toast.makeText(this , "La localisation n'est pas activée" , Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object
    {
        private const val REQUEST_LOCATION_PERMISSION = 1
        private const val REQUEST_CHECK_SETTINGS = 2
    }
}