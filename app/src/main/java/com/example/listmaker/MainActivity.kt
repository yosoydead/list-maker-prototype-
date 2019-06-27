package com.example.listmaker

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
            ListSelectionRecyclerViewAdapter.ListSelectionRecyclerViewListener{
    override fun listItemClicked(list: TaskList) {
        showListDetails(list)
    }

    companion object {
        //this key will be used by the intent to refer to a list whenever it needs
        //to pass one to the new activity
        val INTENT_LIST_KEY = "list"
    }

    //create a variable that will later hold a ref to the RecyclerView
    lateinit var listRecyclerView: RecyclerView

    //make a list manager instance
    val listDataManager = ListDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //make the FAB display a dialog when tapped
        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            showCreateListDialog()

        }

        val lists = listDataManager.readLists()
        //when the main activity is created, initialize the variable for the RecyclerView
        listRecyclerView = findViewById(R.id.list_recyclerview)

        //the recyclerView needs to know what kind of layout to use to display its data
        //here it will use a LinearLayout
        listRecyclerView.layoutManager = LinearLayoutManager(this)

        //the recyclerView needs an adapter to supply data to the list
        listRecyclerView.adapter = ListSelectionRecyclerViewAdapter(lists, this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    //this method will be used by the FAB onClick to display a dialog
    private fun showCreateListDialog(){
        //grab the string resources from the xml file
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)

        //build the dialog
        val builder = AlertDialog.Builder(this)
        //inside the dialog, show an edit text field where the user can
        //add the name of a list
        val listTitleEditText = EditText(this)
        //by specifying the input type, android will know what keyboard
        //is most appropriate
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT

        //set the attributes of the dialog
        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)

        //the setPositiveButton method tells the dialog that a positive action happened
        //and something should occur
        //there can also be nevativeButton for cases such as cancellation
        builder.setPositiveButton(positiveButtonTitle, { dialog, i ->
            //create a new TaskList instance and set its name to be the editText value
            val list = TaskList(listTitleEditText.text.toString())

            //save the list to shared pref
            listDataManager.saveList(list)

            val recycleradapter = listRecyclerView.adapter as ListSelectionRecyclerViewAdapter
            recycleradapter.addList(list)

            dialog.dismiss()

            //after you enter the name of a list, create an intent and open
            //a new screen with "details" where you could add new elements
            showListDetails(list)
        })

        builder.create().show()
    }

    //a function that is used to start an intent
    private fun showListDetails(list: TaskList){
        //basically, this says that im on this screen and i want to go to that screen
        val listDetailIntent = Intent(this, ListDetailsActivity::class.java)

        //this method is used to put some data into the intent that is going to be started
        //stores data as key-value pair
        //the constant is going to be used to reference a certain list
        listDetailIntent.putExtra(INTENT_LIST_KEY, list)

        startActivity(listDetailIntent)
    }
}
