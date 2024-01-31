package com.pawcommunity

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
        btnMap = findViewById(R.id.btn_map)
        btnGps = findViewById(R.id.btn_GPS)
        btnPremium = findViewById(R.id.btn_premium)
        btnAnimals = findViewById(R.id.btn_animals)
        btnSetting = findViewById(R.id.btn_settings)

        btnMap.setOnClickListener{
            setContentView(R.layout.activity_maps)
        }
        btnGps.setOnClickListener{
            setContentView(R.layout.activity_gps)
        }
        btnPremium.setOnClickListener{
            setContentView(R.layout.activity_premium)
        }
        btnAnimals.setOnClickListener{
            setContentView(R.layout.activity_animals)
        }
        btnSetting.setOnClickListener{
            setContentView(R.layout.activity_settings)
        }
    }

    override fun onClick(p0: View?)
    {
        TODO("Not yet implemented")
    }
}