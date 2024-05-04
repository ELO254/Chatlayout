package com.example.chatlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class messgeAdapter(var context: Context, var messageList: List<MessageModule>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val SENDER_VIEW_TYPE = 1
        const val RECEIVER_VIEW_TYPE = 2
    }

    class SenderviewHolder(view: View):RecyclerView.ViewHolder(view){
        var textsent:TextView = view.findViewById(R.id.txtsent)
    }

    class RecieverViewHolder(view: View):RecyclerView.ViewHolder(view){
        var textrecieve:TextView = view.findViewById(R.id.txtrevieve)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1){
            var view = LayoutInflater.from(context).inflate(R.layout.send,parent,false)
            return SenderviewHolder(view)
        }else{
            var view = LayoutInflater.from(context).inflate(R.layout.recieve,parent,false)
            return RecieverViewHolder(view)

        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var user = messageList[position]

        if(holder.javaClass == SenderviewHolder::class.java) {
            holder as SenderviewHolder
            holder.textsent.text = user.message
        }else {
            holder as RecieverViewHolder
            holder.textrecieve.text = user.message
        }




    }

    override fun getItemViewType(position: Int): Int {
        return if(messageList[position].senderId == 1){
            SENDER_VIEW_TYPE
        }else{
            RECEIVER_VIEW_TYPE
        }


    }



}