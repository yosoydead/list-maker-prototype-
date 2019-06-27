package com.example.listmaker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

//this activity will be used to display the contents of each list from the recycler view
class ListDetailsActivity : AppCompatActivity() {

    lateinit var list: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)

        //receive the list passed from parcelable
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)

        title = list.name
    }
}
