package com.ToxicBakery.learnandroid.trello.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.HORIZONTAL
import android.support.v7.widget.RecyclerView
import com.ToxicBakery.learnandroid.trello.R
import com.ToxicBakery.learnandroid.trello.board.BoardManager
import com.ToxicBakery.learnandroid.trello.board.OnUpdateBoardListener
import com.ToxicBakery.learnandroid.trello.model.Board
import com.ToxicBakery.learnandroid.trello.model.Card
import com.ToxicBakery.learnandroid.trello.recycler.BoardAdapter

class MainActivity : AppCompatActivity(), OnUpdateBoardListener {
    // FIXME Save this
    val boardManager: BoardManager = BoardManager()

    val boardAdapter: BoardAdapter = BoardAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boardAdapter.boardManager = boardManager

        val layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        val recycler = findViewById(R.id.recycler) as RecyclerView
        recycler.layoutManager = layoutManager
        recycler.adapter = boardAdapter

        findViewById(R.id.fab)
                .setOnClickListener { createBoard() }
    }

    override fun onResume() {
        super.onResume()

        boardManager.addOnUpdateBoardListener(this)
    }

    override fun onPause() {
        super.onPause()

        boardManager.removeOnUpdateBoardListener(this)
    }

    fun createBoard() {
        val cards = listOf(
                Card(description = "Sample card")
        )

        val board = Board(
                name = "New Board",
                cards = cards)

        boardManager.addOrUpdateBoard(board)
    }

    override fun onUpdateBoard(board: Board) {
        boardAdapter.boards = boardManager.getBoards()
    }

}
