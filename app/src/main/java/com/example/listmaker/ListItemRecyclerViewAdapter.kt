package com.example.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListItemRecyclerViewAdapter(val list: TaskList) :
    RecyclerView.Adapter<ListItemRecyclerViewAdapter.ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_view_holder, parent, false)

        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        if(holder != null){
            holder.taskTextView.text = list.tasks[position]
        }
    }

    inner class ListItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val taskTextView = itemView.findViewById<TextView>(R.id.textview_task)
    }
}
