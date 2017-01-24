package com.ToxicBakery.learnandroid.trello.recycler

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.board.BoardManager
import com.ToxicBakery.learnandroid.trello.model.Board
import timber.log.Timber

class BoardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val toolbar = itemView!!.findViewById(R.id.toolbar) as Toolbar
    val recyclerView = itemView!!.findViewById(R.id.recycler) as RecyclerView
    val buttonAddCard = itemView!!.findViewById(R.id.add_card) as Button
    val adapter = CardAdapter()

    var boardManager = BoardManager()

    init {
        buttonAddCard.setOnClickListener { Timber.d("Add card") }
        recyclerView.layoutManager = LinearLayoutManager(itemView!!.context, VERTICAL, false)
        recyclerView.adapter = adapter
    }

    fun bind(board: Board, boardManager: BoardManager) {
        Timber.d("Binding %s", board.name)
        this.boardManager = boardManager

        adapter.boardManager = boardManager
        adapter.board = board

        toolbar.title = board.name
        adapter.cards = board.cards
    }

}
