package com.pawcommunity.subcription

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.pawcommunity.R
import com.pawcommunity.main.MainActivity

class PremiumActivity : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium)

        val btnInscription = findViewById<Button>(R.id.btn_inscription)
        val backButton = findViewById<ImageView>(R.id.backbtnPremium)

        btnInscription.setOnClickListener {
            val intent = Intent(this , InscriptionActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



}
