package com.ToxicBakery.learnandroid.trello.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.model.Card

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val description: TextView = itemView.findViewById(R.id.description) as TextView

    fun bind(card: Card) {
        description.text = card.description
    }

}