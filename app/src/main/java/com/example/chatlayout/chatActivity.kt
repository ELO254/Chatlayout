package com.example.chatlayout

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class chatActivity : AppCompatActivity() {


    lateinit var editText: EditText
    lateinit var imageView: ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var messageList:MutableList<MessageModule>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        var name = intent.getStringExtra("name")
        supportActionBar?.title = name

        messageList = mutableListOf()

        editText = findViewById(R.id.edtchattext)
        imageView = findViewById(R.id.imgsend)
        recyclerView = findViewById(R.id.chatrecy)

        var adapter = messgeAdapter(this,messageList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        imageView.setOnClickListener {
            var text = editText.text.toString()
            val message = MessageModule(text, 1)
            messageList.add(message)

            adapter.notifyItemInserted(messageList.size - 1)
            recyclerView.smoothScrollToPosition(messageList.size - 1)
            editText.setText("")
        }



    }
}