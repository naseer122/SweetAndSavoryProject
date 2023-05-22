package com.crown.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecipesAdapter(private val recipes: MutableList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val VIEW_TYPE_FLAVOR_TITLE = 0
        private const val VIEW_TYPE_RECIPE_TITLE = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_FLAVOR_TITLE -> {
                val flavorView = inflater.inflate(R.layout.item_flavor, parent, false)
                FlavorTitleViewHolder(flavorView)
            }
            VIEW_TYPE_RECIPE_TITLE -> {
                val recipeView = inflater.inflate(R.layout.item_recipe, parent, false)
                RecipeViewHolder(recipeView)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FlavorTitleViewHolder -> {
                val flavorTitle = recipes[position] as Flavor
                holder.bind(flavorTitle)
            }
            is RecipeViewHolder -> {
                val recipe = recipes[position] as Recipe
                holder.bind(recipe)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (recipes[position]) {
            is Flavor -> VIEW_TYPE_FLAVOR_TITLE
            is Recipe -> VIEW_TYPE_RECIPE_TITLE
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }
    fun removeItem(position: Int) {
        recipes.removeAt(position)
        notifyItemRemoved(position)
    }
}