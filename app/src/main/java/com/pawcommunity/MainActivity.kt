package com.pawcommunity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragment.MapFragment

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() , View.OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisation des boutons

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_map -> {
                    replaceFragment(MapFragment())
                    true
                }
                R.id.navigation_animal -> {
                    val intent = Intent(this, AnimalsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_subscription -> {
                    replaceFragment(PremiumFragment())
                    true
                }
                R.id.navigation_setting -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onClick(p0: View?)
    {
        TODO("Not yet implemented")
    }
}