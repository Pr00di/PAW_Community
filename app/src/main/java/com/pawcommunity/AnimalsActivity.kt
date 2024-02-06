package com.pawcommunity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimalsActivity : AppCompatActivity()
{
    lateinit var btnAddAnimal : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var listAdapter: AnimalAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        btnAddAnimal = findViewById(R.id.add_animal_list)

        btnAddAnimal.setOnClickListener {
            val intent = Intent(this, AddAnimalActivity::class.java)
            startActivity(intent)
        }

        //Configuration du recyclerView
        recyclerView = findViewById(R.id.liste_animal)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


}