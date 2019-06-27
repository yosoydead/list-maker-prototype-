package com.example.listmaker

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class ListSelectionRecyclerViewAdapter :
    RecyclerView.Adapter<ListSelectionRecyclerViewAdapter.ListSelectionViewHolder>() {

    //this is just some dummy data for the list to display
    val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //this function tells the RecyclerView how many items it will have to display
    //for now, return only the size of the dummy data array
    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ListSelectionViewHolder(view: View): RecyclerView.ViewHolder(view){

    }
}
