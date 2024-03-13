package com.pawcommunity.animals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.textfield.TextInputLayout
import com.pawcommunity.R

class AddAnimalActivity : AppCompatActivity()
{
    private lateinit var imageView: ImageView
    private lateinit var nameInputLayout: TextInputLayout
    private lateinit var typeInputLayout: TextInputLayout
    private lateinit var ageInputLayout: TextInputLayout
    private lateinit var addButton: Button
    private var imageUri: String? = null

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_animals)

        imageView = findViewById(R.id.AnimalPhoto)
        nameInputLayout = findViewById(R.id.layout_name)
        typeInputLayout = findViewById(R.id.layout_type)
        ageInputLayout = findViewById(R.id.layout_age)
        addButton = findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val name = nameInputLayout.editText?.text.toString()
            val type = typeInputLayout.editText?.text.toString()
            val ageString = ageInputLayout.editText?.text.toString()
            val age = ageString.toIntOrNull()

            // Validation des entrées de l'utilisateur
            if (name.isBlank() || type.isBlank() || age == null || imageUri == null) {
                Toast.makeText(this, "Veuillez compléter tous les champs et sélectionner une photo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Création de l'Intent pour retourner les résultats
            val resultIntent = Intent().apply {
                putExtra("animal_name", name)
                putExtra("animal_type", type)
                putExtra("animal_age", age)
                putExtra("animal_photo", imageUri)
            }

            setResult(RESULT_OK, resultIntent)
            finish()
        }

        imageView.setOnClickListener{
            ImagePicker.with(this)
                .crop()
                .compress(720)
                .maxResultSize(720, 720)
                .start(IMAGE_REQUEST_CODE)
        }

        val backBtn = findViewById<ImageView>(R.id.backbtnAddAnimals)

        backBtn.setOnClickListener {
            val intent = Intent(this, AnimalsActivity::class.java)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int , resultCode: Int , data: Intent?)
    {
        super.onActivityResult(requestCode , resultCode , data)

        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            // L'utilisateur a sélectionné avec succès une image; mettez à jour l'ImageView avec cette nouvelle image.
            // Récupérer l'URI de l'image sélectionnée et l'afficher dans l'ImageView
            imageUri = data?.data.toString()
            imageView.setImageURI(data?.data)
        }
    }
}