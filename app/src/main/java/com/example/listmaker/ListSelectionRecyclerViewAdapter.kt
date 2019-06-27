package com.example.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListSelectionRecyclerViewAdapter :
    RecyclerView.Adapter<ListSelectionRecyclerViewAdapter.ListSelectionViewHolder>() {

    //this is just some dummy data for the list to display
    val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        //use a LayoutInflater object to create the layout needed for the recyclerView
        //it needs the context of the activity to create itself
        //and then, inflates the layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_selection_view_holder, parent, false)

        //here, after creating the view, populate its fields by using the ViewHolder
        return ListSelectionViewHolder(view)
    }

    //this function tells the RecyclerView how many items it will have to display
    //for now, return only the size of the dummy data array
    override fun getItemCount(): Int {
        return listTitles.size
    }

    //this method binds the desired data to the view holder at the specified position
    //it is called repeatedly as you scroll through the recycler view
    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        if(holder != null){
            holder.listPosition.text = (position+1).toString()
            holder.listTitle.text = listTitles[position]
        }
    }

    inner class ListSelectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //here, get a ref to the fields you want to populate from a specific view
        val listPosition = itemView.findViewById<TextView>(R.id.itemNumber)
        val listTitle = itemView.findViewById<TextView>(R.id.itemString)

    }
}
