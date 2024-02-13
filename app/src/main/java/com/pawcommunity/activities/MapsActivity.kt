package com.pawcommunity.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity() , OnMapReadyCallback
{

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap)
    {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val aix_en_provence = LatLng(43.53 , 5.43)
        mMap.addMarker(MarkerOptions().position(aix_en_provence).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aix_en_provence))
    }
}