package com.ToxicBakery.learnandroid.trello.board

import com.ToxicBakery.learnandroid.trello.model.Board
import java.util.*

class BoardManager {

    private val boards: MutableSet<Board> = LinkedHashSet()
    private val boardUpdateListeners: MutableList<OnUpdateBoardListener> = LinkedList()

    fun addOrUpdateBoard(board: Board) {
        boards.add(board)
        boardUpdateListeners.forEach { listener -> listener.onUpdateBoard(board) }
    }

    fun removeBoard(board: Board) {
        boards.remove(board)
    }

    fun getBoards(): List<Board> {
        return LinkedList(boards)
    }

    fun addOnUpdateBoardListener(onUpdateBoardListener: OnUpdateBoardListener) {
        boardUpdateListeners.add(onUpdateBoardListener)
    }

    fun removeOnUpdateBoardListener(onUpdateBoardListener: OnUpdateBoardListener) {
        boardUpdateListeners.remove(onUpdateBoardListener)
    }

}