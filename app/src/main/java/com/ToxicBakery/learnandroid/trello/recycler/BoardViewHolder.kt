package com.ToxicBakery.learnandroid.trello.recycler

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.model.Board
import timber.log.Timber

class BoardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val toolbar = itemView!!.findViewById(R.id.toolbar) as Toolbar
    val recyclerView = itemView!!.findViewById(R.id.recycler) as RecyclerView
    val buttonAddCard = itemView!!.findViewById(R.id.add_card) as Button

    init {
        buttonAddCard.setOnClickListener { Timber.d("Add card") }
    }

    fun bind(board: Board) {
        Timber.d("Binding %s", board.name)
        toolbar.title = board.name
    }

}
