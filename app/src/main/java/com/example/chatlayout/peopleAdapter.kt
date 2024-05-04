package com.example.chatlayout

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class peopleAdapter(var context: Context, var peopleList:List<People>):RecyclerView.Adapter<peopleAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        var name: TextView = view.findViewById(R.id.txtname)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.people, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return peopleList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var d = peopleList[position]
        holder.name.text = d.name

        holder.itemView.setOnClickListener {
            var intent = Intent(context, chatActivity::class.java)
            intent.putExtra("name",peopleList[position].name)
            context.startActivity(intent)
        }
    }
}