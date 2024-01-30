package com.pawcommunity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MapActivity : AppCompatActivity()
{ //Layout for the window of the map (where you can see all the indication)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMap = setOn
    }
}
