package com.example.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//made the recyclerView adapter to accept a list defined later in the lifecycle
class ListSelectionRecyclerViewAdapter(val lists: ArrayList<TaskList>) :
    RecyclerView.Adapter<ListSelectionRecyclerViewAdapter.ListSelectionViewHolder>() {

    //this is just some dummy data for the list to display
    //val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")


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
    //update this method to use the array given as param
    override fun getItemCount(): Int {
//        return listTitles.size
        return lists.size
    }

    //this method binds the desired data to the view holder at the specified position
    //it is called repeatedly as you scroll through the recycler view
    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        if(holder != null){
            holder.listPosition.text = (position+1).toString()
            holder.listTitle.text = lists.get(position).name
        }
    }

    //create a new method that sets the data that will be used by the recycler
    fun addList(list: TaskList){
        lists.add(list)

        //inform the adapter that it should query its data and update the recyclerView
        //now the data used will be the passed one in the classes constructor
        notifyDataSetChanged()
    }

    inner class ListSelectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //here, get a ref to the fields you want to populate from a specific view
        val listPosition = itemView.findViewById<TextView>(R.id.itemNumber)
        val listTitle = itemView.findViewById<TextView>(R.id.itemString)

    }
}
