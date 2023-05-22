package com.crown.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlavorTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
    private val flavorTextView: TextView = itemView.findViewById(R.id.flavorTextView)

    fun bind(flavor: Flavor) {
        flavorTextView.text = flavor.toString()
    }

}