package com.example.listmaker

import android.content.Context
import android.preference.PreferenceManager

//this class will be used to manage the lists created by the user
//also, it will use SharedPreferences to store and retrieve data as long as the app is running
//SharedPreferences stores key-value pairs and it is an easy way to store data for small apps
class ListDataManager(val context: Context) {

    //this function will make the data persist
    fun saveList(list: TaskList){
        //access the shared preferences of the app and using its manager, call the edit()
        //to start storing data into it
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()

        //here, shared pref will write a TaskList as a set of string
        //the arrayList cant be stored directly as a string so it needs to be converted into a hashSet
        sharedPreferences.putStringSet(list.name, list.tasks.toHashSet())

        //write to the shared pref file
        sharedPreferences.apply()
    }

    fun readLists(): ArrayList<TaskList>{
        //grab a ref to the shared pref file
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        //access the files contents
        val sharedPreferencesContents = sharedPreferences.all

        //declare an empty array that will later contain all the values from the file
        val taskLists = ArrayList<TaskList>()

        //write a for loop to add tasks to the list
        for(item in sharedPreferencesContents){
            //retrieve the hashSet of items
            val itemsHashSet = item.value as HashSet<String>

            //create a new taskList object which will have a name and a list of values
            val list = TaskList(item.key, ArrayList(itemsHashSet))

            taskLists.add(list)
        }

        //return the list of tasks
        return taskLists
    }
}