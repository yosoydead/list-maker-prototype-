package com.example.listmaker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.widget.EditText

//this activity will be used to display the contents of each list from the recycler view
class ListDetailsActivity : AppCompatActivity() {

    lateinit var list: TaskList

    //ref to this activity's recycler view
    lateinit var listItemRecyclerView: RecyclerView

    lateinit var addTaskButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)

        //receive the list passed from parcelable
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)
        title = list.name

        //initialize the recycler view variable
        listItemRecyclerView = findViewById(R.id.list_items_recyclerview)

        //initialize its adapter
        listItemRecyclerView.adapter = ListItemRecyclerViewAdapter(list)

        //specify the recycler views layout manager
        listItemRecyclerView.layoutManager = LinearLayoutManager(this)

        //hook up the FAB
        addTaskButton = findViewById(R.id.add_task_button)
        addTaskButton.setOnClickListener{
            showCreateTaskDialog()
        }
    }

    private fun showCreateTaskDialog(){
        val taskEditText = EditText(this)
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT

        AlertDialog.Builder(this)
            .setTitle(R.string.task_to_add)
            .setView(taskEditText)
            .setPositiveButton(R.string.add_task, { dialog, which ->
                val task = taskEditText.text.toString()
                list.tasks.add(task)

                val recyclerAdapter = listItemRecyclerView.adapter
                recyclerAdapter.notifyItemInserted(list.tasks.size)
                dialog.dismiss()
            })
            .create()
            .show()
    }
}
