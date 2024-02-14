package com.pawcommunity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.pawcommunity.GpsActivity
import com.pawcommunity.map.MapActivity
import com.pawcommunity.subcription.PremiumActivity
import com.pawcommunity.R
import com.pawcommunity.settings.SettingsActivity
import com.pawcommunity.animals.AnimalsActivity

class MainActivity : AppCompatActivity() , View.OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisation des boutons

        val btnMap = findViewById<Button>(R.id.btn_map)
        btnMap.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        val btnGps = findViewById<Button>(R.id.btn_GPS)
        btnGps.setOnClickListener{
            val intent = Intent(this, GpsActivity::class.java)
            startActivity(intent)
        }

        val btnPremium = findViewById<Button>(R.id.btn_premium)
        btnPremium.setOnClickListener{
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }

        val btnAnimals = findViewById<Button>(R.id.btn_animals)
        btnAnimals.setOnClickListener{
            val intent = Intent(this, AnimalsActivity::class.java)
            startActivity(intent)
        }

        val btnSetting = findViewById<Button>(R.id.btn_settings)
        btnSetting.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(p0: View?)
    {
        TODO("Not yet implemented")
    }
}