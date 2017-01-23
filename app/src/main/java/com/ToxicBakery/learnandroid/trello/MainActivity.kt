package com.ToxicBakery.learnandroid.trello

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.HORIZONTAL
import android.support.v7.widget.RecyclerView
import com.ToxicBakery.learnandroid.trello.recycler.BoardAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        val recycler = findViewById(R.id.recycler) as RecyclerView
        recycler.layoutManager = layoutManager
        recycler.adapter = BoardAdapter()
    }

}
