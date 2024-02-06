package com.pawcommunity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class AnimalsActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
    }

    data class Animal(
        val id: Int,
        val nom: String,
        val age: Int,
        val photo: String
    )

    val animaux = listOf(
        Animal(1,"Chat", 3, "default_image.xml"),
        Animal(2,"Chien", 5, "default_image.xml"),
        Animal(3,"Lapin", 4, "default_image.xml"),
    )

   // val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_animaux)
    val adapter = AnimalAdapter(animaux)
    //recyclerView.adapter = adapter

}