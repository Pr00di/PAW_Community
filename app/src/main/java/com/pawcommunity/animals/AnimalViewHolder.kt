package com.pawcommunity.animals

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pawcommunity.R

class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.animal_photo)
    val nameTextView: TextView = itemView.findViewById(R.id.animal_name)
    val typeTextView: TextView = itemView.findViewById(R.id.animal_type)
    val ageTextView: TextView = itemView.findViewById(R.id.animal_age)
    // ... autres vues que vous pourriez avoir besoin d'afficher dans votre liste
}
