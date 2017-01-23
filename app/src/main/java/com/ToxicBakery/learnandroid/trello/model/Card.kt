package com.ToxicBakery.learnandroid.trello.model

import java.util.*

class Card(val uuid: String = UUID.randomUUID().toString(),
           val description: String) {

    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Card) {
            return uuid == other.uuid
        }

        return false
    }

}