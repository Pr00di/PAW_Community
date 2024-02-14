package com.pawcommunity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pawcommunity.models.Animal
import com.pawcommunity.R
import com.squareup.picasso.Picasso

//import com.pawcommunity.animals.AnimalsActivity.Animal

class AnimalAdapter(private val animals: MutableList<Animal>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photoView: ImageView = view.findViewById(R.id.animal_photo)
        val nameView: TextView = view.findViewById(R.id.animal_name)
        val ageView: TextView = view.findViewById(R.id.animal_age)
        val typeView: TextView = view.findViewById(R.id.animal_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder
    {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animals , parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder , position: Int) {
        val animal = animals[position]
        holder.nameView.text = animal.name
        holder.ageView.text = animal.age.toString()
        holder.typeView.text = animal.type

        // Utilisez Picasso pour charger l'image
        if (animal.photoUri.isNotEmpty()) {
            Picasso.get()
                .load(animal.photoUri)
                .into(holder.photoView)
        }
    }

    override fun getItemCount() = animals.size

    fun addAnimal(animal: Animal) {
        animals.add(animal)
        notifyItemInserted(animals.size - 1)
    }
}

