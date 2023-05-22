package com.crown.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recipesAdapter: RecipesAdapter
    private val recipesList = mutableListOf<Any>()
    lateinit var titleEditText : EditText
    lateinit var descriptionEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recipesAdapter = RecipesAdapter(recipesList)
        recyclerView.adapter = recipesAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
         titleEditText = findViewById(R.id.titleEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        val addSweetButton = findViewById<Button>(R.id.addSweetButton)
        val addSavoryButton = findViewById<Button>(R.id.addSavoryButton)

        addSweetButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val sweetRecipe = Recipe(title, description, Flavor.SWEET)
            recipesList.add(Flavor.SWEET)
            recipesList.add(sweetRecipe)
            recipesAdapter.notifyItemRangeInserted(recipesList.size - 2, 2)
            clearForm()
        }

        addSavoryButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val savoryRecipe = Recipe(title, description, Flavor.SAVORY)
            recipesList.add(Flavor.SAVORY)
            recipesList.add(savoryRecipe)
            recipesAdapter.notifyItemRangeInserted(recipesList.size - 2, 2)
            clearForm()
        }
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(recipesAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun clearForm() {
        titleEditText.text.clear()
        descriptionEditText.text.clear()
    }
}

