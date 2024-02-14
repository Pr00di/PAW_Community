package com.pawcommunity.subcription

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.pawcommunity.R
import com.pawcommunity.main.MainActivity

class InscriptionActivity : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        val btn_back_connection = findViewById<Button>(R.id.btnBackConnection)
        val backBtnInscription = findViewById<ImageView>(R.id.backbtnInscription)

        btn_back_connection.setOnClickListener {
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }

        backBtnInscription.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}