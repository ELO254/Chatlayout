package com.example.chatlayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var peoplelist = mutableListOf<People>(People("john",1),People("elvis",2))

        var recycler:RecyclerView = findViewById(R.id.peoplerecy)
        var adapter = peopleAdapter(this,peoplelist)

        recycler.adapter = adapter

        recycler.layoutManager = LinearLayoutManager(this)



    }
}