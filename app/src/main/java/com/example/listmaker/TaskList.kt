package com.example.listmaker

import android.os.Parcel
import android.os.Parcelable

/*
    this class will represent the model of a given list
    it will have a name and a list of associated tasks
    this type of object cant be passed around to intents
    it needs to inherit from Parcelable. this will break down the object
        into objects that android understands: like string, bool, etc

    intents use a bundle to transfer data which can contain Parcelable objects

*/
class TaskList(val name: String, val tasks: ArrayList<String> = ArrayList()): Parcelable {

    //this makes it so that a TaskList object can be created from a passed-in Parcel
    //it grabs values from Parcel for the title and for the list of tasks
    //then passed them into the primary constructor
    constructor(source: Parcel): this(
        source.readString(),
        source.createStringArrayList()
    )

    //this method is called whenever a Parcel object needs to be created from my object
    //into this Parcel, write the name and list of tasks given
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeStringList(tasks)
    }

    override fun describeContents() = 0

    //Parcelable requires a static class that overrides a couple of methods
    companion object CREATOR: Parcelable.Creator<TaskList>{
        override fun createFromParcel(source: Parcel): TaskList = TaskList(source)
        override fun newArray(size: Int): Array<TaskList?> = arrayOfNulls(size)
    }
}