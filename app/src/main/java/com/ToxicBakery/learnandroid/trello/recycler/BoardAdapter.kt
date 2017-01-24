package com.ToxicBakery.learnandroid.trello.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.board.BoardManager
import com.ToxicBakery.learnandroid.trello.model.Board
import kotlin.properties.Delegates

class BoardAdapter : RecyclerView.Adapter<BoardViewHolder>(), AutoUpdatableAdapter {

    var boardManager: BoardManager = BoardManager()

    var boards: List<Board> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> o.uuid == n.uuid }
    }

    override fun getItemCount(): Int {
        return boards.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder?, position: Int) {
        val board = boards[position]
        holder!!.bind(board, boardManager)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BoardViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val view = inflater.inflate(R.layout.board, parent, false)
        return BoardViewHolder(view)
    }

}
