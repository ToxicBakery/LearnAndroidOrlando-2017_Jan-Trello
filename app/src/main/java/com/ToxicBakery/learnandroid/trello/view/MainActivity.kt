package com.ToxicBakery.learnandroid.trello.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.HORIZONTAL
import android.support.v7.widget.RecyclerView
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.board.BoardManager
import com.ToxicBakery.learnandroid.trello.model.Board
import com.ToxicBakery.learnandroid.trello.recycler.BoardAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    // FIXME Save this
    val boardManager: BoardManager = BoardManager()
    val boardAdapter: BoardAdapter = BoardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        val recycler = findViewById(R.id.recycler) as RecyclerView
        recycler.layoutManager = layoutManager
        recycler.adapter = boardAdapter

        findViewById(R.id.fab)
                .setOnClickListener { createBoard() }
    }

    fun createBoard() {
        val board = Board(
                name = "New Board",
                cards = LinkedList())

        boardManager.addOrUpdateBoard(board)
        boardAdapter.boards = boardManager.getBoards()
    }

}
