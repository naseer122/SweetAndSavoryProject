package com.crown.recyclerview

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

    fun bind(recipe: Recipe) {
        titleTextView.text = recipe.title
        descriptionTextView.text = recipe.description
        itemView.setOnClickListener {
            val context = itemView.context
            val dialog = AlertDialog.Builder(context)
                .setTitle(recipe.title)
                .setMessage(recipe.description)
                .setPositiveButton("OK", null)
                .create()
            dialog.show()

    }


}

}