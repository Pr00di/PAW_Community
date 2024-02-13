package com.pawcommunity.activities

import com.pawcommunity.R

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val btnMap = findViewById<Button>(R.id.navigation_map)
        btnMap.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val btnPremium = findViewById<Button>(R.id.navigation_subscription)
        btnPremium.setOnClickListener{
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }

        val btnAnimals = findViewById<Button>(R.id.navigation_animal)
        btnAnimals.setOnClickListener {
            val intent = Intent(this , AnimalsActivity::class.java)
            startActivity(intent)
        }

        val btnSettings = findViewById<Button>(R.id.navigation_setting)
        btnAnimals.setOnClickListener {
            val intent = Intent(this , SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}