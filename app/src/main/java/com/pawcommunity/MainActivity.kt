package com.pawcommunity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener
{
    lateinit var btnMap : Button
    lateinit var btnGps : Button
    lateinit var btnPremium : Button
    lateinit var btnAnimals : Button
    lateinit var btnSetting : Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisation des boutons
        btnMap = findViewById(R.id.btn_map)
        btnGps = findViewById(R.id.btn_GPS)
        btnPremium = findViewById(R.id.btn_premium)
        btnAnimals = findViewById(R.id.btn_animals)
        btnSetting = findViewById(R.id.btn_settings)

        btnMap.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        btnGps.setOnClickListener{
            val intent = Intent(this, GpsActivity::class.java)
            startActivity(intent)
        }
        btnPremium.setOnClickListener{
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }
        btnAnimals.setOnClickListener{
            val intent = Intent(this, AnimalsActivity::class.java)
            startActivity(intent)
        }
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