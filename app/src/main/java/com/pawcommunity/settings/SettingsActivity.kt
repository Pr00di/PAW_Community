package com.pawcommunity.settings

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.pawcommunity.R
import com.pawcommunity.main.MainActivity

class SettingsActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backBtnSettings = findViewById<ImageView>(R.id.back_button_settings)

        backBtnSettings.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}