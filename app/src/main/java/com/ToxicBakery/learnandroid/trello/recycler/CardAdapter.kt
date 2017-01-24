package com.ToxicBakery.learnandroid.trello.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.model.Card
import kotlin.properties.Delegates

class CardAdapter : RecyclerView.Adapter<CardViewHolder>(), AutoUpdatableAdapter {

    var cards: List<Card> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> o.uuid == n.uuid }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        val card = cards[position]
        holder!!.bind(card)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val view = inflater.inflate(R.layout.card, parent, false)
        return CardViewHolder(view)
    }

}
