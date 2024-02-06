package com.pawcommunity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.pawcommunity.AnimalsActivity.Animal

class AnimalAdapter(private val animals: List<Animal>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(animal: Animal) {
           // itemView.findViewById<ImageView>(R.id.imageViewAnimalPhoto).setImageResource(R.drawable.default_image) // Remplacez par la gestion de l'image
            //itemView.findViewById<TextView>(R.id.textViewAnimalName).text = animal.nom
            //itemView.findViewById<TextView>(R.id.textViewAnimalAge).text = "${animal.age} ans"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_animals, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
       // holder.bind(animals[position])
    }

    override fun getItemCount(): Int = animals.size
}
