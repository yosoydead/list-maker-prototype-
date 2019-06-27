package com.example.listmaker

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

class MainActivity : AppCompatActivity() {

    //create a variable that will later hold a ref to the RecyclerView
    lateinit var listRecyclerView: RecyclerView

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

        //when the main activity is created, initialize the variable for the RecyclerView
        listRecyclerView = findViewById(R.id.list_recyclerview)

        //the recyclerView needs to know what kind of layout to use to display its data
        //here it will use a LinearLayout
        listRecyclerView.layoutManager = LinearLayoutManager(this)

        //the recyclerView needs an adapter to supply data to the list
        listRecyclerView.adapter = ListSelectionRecyclerViewAdapter()
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
            dialog.dismiss()
        })

        builder.create().show()
    }
}
