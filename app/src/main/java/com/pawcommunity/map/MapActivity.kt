package com.pawcommunity.map

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.pawcommunity.R
import com.pawcommunity.main.MainActivity

class MapActivity : AppCompatActivity(), OnMapReadyCallback
{
    companion object {
        const val  REQUEST_LOCATION_PERMISSION = 1
    }
    private var mGoogleMap:GoogleMap? = null
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_maps)

            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.mapFragment) as SupportMapFragment
            mapFragment.getMapAsync(this)

            val backBtnMap = findViewById<ImageView>(R.id.backbtnMap)

            backBtnMap.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        // Vérifiez encore une fois la permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mGoogleMap?.isMyLocationEnabled = true
            mGoogleMap?.uiSettings?.isMyLocationButtonEnabled = true

            fusedLocationProviderClient.lastLocation.addOnSuccessListener { location : Location? ->
                location?.let {
                    val userLocation = LatLng(it.latitude, it.longitude)
                    mGoogleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 16.0f))
                }
            }
        }
    }
}