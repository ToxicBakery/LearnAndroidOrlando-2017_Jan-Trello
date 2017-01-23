package com.ToxicBakery.learnandroid.trello.board

import com.ToxicBakery.learnandroid.trello.model.Board
import java.util.*

class BoardManager {

    private val boards: MutableSet<Board> = LinkedHashSet()

    fun addOrUpdateBoard(board: Board) {
        boards.add(board)
    }

    fun removeBoard(board: Board) {
        boards.remove(board)
    }

    fun getBoards(): List<Board> {
        return LinkedList(boards)
    }

}