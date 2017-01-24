package com.ToxicBakery.learnandroid.trello.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.board.BoardManager
import com.ToxicBakery.learnandroid.trello.model.Board
import com.ToxicBakery.learnandroid.trello.model.Card

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val description: TextView = itemView.findViewById(R.id.description) as TextView

    var board = Board()
    var boardManager = BoardManager()

    fun bind(card: Card, board: Board, boardManager: BoardManager) {
        this.board = board
        this.boardManager = boardManager

        description.text = card.description
    }

}