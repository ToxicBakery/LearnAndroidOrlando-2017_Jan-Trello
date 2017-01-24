package com.ToxicBakery.learnandroid.trello.model

import java.util.*

class Board(val uuid: String = UUID.randomUUID().toString(),
            val name: String = "",
            cards: List<Card> = listOf()) {

    val cards: List<Card>

    init {
        this.cards = LinkedList(cards)
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Board) {
            return uuid == other.uuid
        }

        return false
    }

}