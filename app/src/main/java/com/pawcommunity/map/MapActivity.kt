package com.pawcommunity.map

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.pawcommunity.R
import com.pawcommunity.main.MainActivity

class MapActivity : AppCompatActivity(), OnMapReadyCallback
{
    private var mGoogleMap:GoogleMap? = null
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
        }

    override fun onMapReady(googleMap: GoogleMap)
    {
        mGoogleMap = googleMap
    }
}