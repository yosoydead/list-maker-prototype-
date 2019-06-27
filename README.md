* The name of this project is: ListMaker. It will be a to-do list organizer. (book **Android apprentice**)
* This app will use a **RecyclerView** instead of a ListView.
* [x] Step I:
    * 1. [x] **content_main.xml** is the actual layout that contains the initial TextView (it is imported into the **activity_main.xml**). Open it and replace the TextView with a **RecyclerView**. 
    * 2. [x] Implement the RecyclerView **Adapter** and **ViewHolder**. These are required components in order to make the RecyclerView functional.
        * The RecyclerView asks the **Adapter** for an item, or a **ViewHolder** at a given position
        * The **Adapter** gives the RecyclerView data it wants to show
        * The **ViewHolders** are the visual containers for the item. You tell the RecyclerView how each item should look like
        * The **Adapter** reaches into the pool of **ViewHolders** that have been created
        * Either a new **ViewHolder** is returned or a new one is created
        * The **Adapter** then binds this **ViewHolder** to a data item at the given position
        * The **ViewHolder** is returned back to the RecyclerView for display
* [x] Step II:
    * 1. [x] The floating action button has the image of an email button by defailt. Change it so the user knows it helps add an item to the list
    * 2. [x] Make the FAB display a dialog instead of a SnackBar. Using that dialog, the user will be able to add items to the list. Use string resources for the values in the dialog
    * 3. [x] Create the model of a list of items
    * 4. [x] Create another class used to manage the lists
    * 5. [x] Use **shared preferences** to transfer data/save data
    * 6. [x] Use the manager class during the dialog menu
* [ ] Step III:
    * 1. [ ]  Create a new empty activity that will be used to navigate to a separate screen where you can add items to a list.
    * 2. [ ] Register the new activity in the **AndroidManifest.xml** file
    * 3. [ ] Use **Intents** to navigate between the main activity and the second one
    * 4. [ ] Use the **Parcelable** interface on the **TaskList** class to make its data able to be passed around between activities. An intent cannot pass around that type of object
    * 5. [ ] Implement an **onClick** listener to each item in the RecyclerView
