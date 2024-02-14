package com.pawcommunity.animals

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pawcommunity.models.Animal
import com.pawcommunity.adapters.AnimalAdapter
import com.pawcommunity.main.MainActivity
import com.pawcommunity.R

@Suppress("DEPRECATION")
class AnimalsActivity : AppCompatActivity()
{
    lateinit var btnAddAnimal : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var listAdapter: AnimalAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        recyclerView = findViewById(R.id.liste_animal)
        btnAddAnimal = findViewById(R.id.add_animal_list)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialisation de la liste et de l'adaptateur
        val animalsList = mutableListOf<Animal>()
        listAdapter = AnimalAdapter(animalsList)
        recyclerView.adapter = listAdapter

        btnAddAnimal.setOnClickListener {
            val intent = Intent(this, AddAnimalActivity::class.java)
            startActivityForResult(intent, AddAnimalActivity.IMAGE_REQUEST_CODE)
        }

        val backBtnAnimal = findViewById<ImageView>(R.id.back_btn_list_animal)
        backBtnAnimal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    // Méthode pour gérer le résultat de AddAnimalActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AddAnimalActivity.IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Récupérer les données
            val name = data.getStringExtra("animal_name")
            val type = data.getStringExtra("animal_type")
            val age = data.getIntExtra("animal_age", -1)
            val photoUri = data.getStringExtra("animal_photo")

            if (name != null && type != null && age != -1 && photoUri != null) {
                // Ajouter l'animal à la liste et notifier l'adaptateur
                val newAnimal = Animal(name, type, age, photoUri)
                listAdapter.addAnimal(newAnimal)
            }
        }
    }


}