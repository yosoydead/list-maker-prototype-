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
* [x] Step III:
    * 1. [x]  Create a new empty activity that will be used to navigate to a separate screen where you can add items to a list.
    * 2. [x] Register the new activity in the **AndroidManifest.xml** file
    * 3. [ ] Use **Intents** to navigate between the main activity and the second one
    * 4. [x] Use the **Parcelable** interface on the **TaskList** class to make its data able to be passed around between activities. An intent cannot pass around that type of object
    * 5. [x] Implement an **onClick** listener to each item in the RecyclerView
* [x] Step IV:
    * 1. [x] Add a **RecyclerView** to the layout of the newly created activity to let the user see the contents of the list
    * 2. [x] Implement the RecyclerView **Adapter** and **ViewHolder** of the new activity
    * 3. [x] Create a new layout file that will be used to show items from the list passed from intent
    * 4. [x] Implement a **FAB** for the list details activity
    * 5. [x] Add string resources for the fields from the dialog opened by the new **FAB**
    * 6. [x] In the **MainActivity**, modify the intent opening method so that when the activity opens an intent, it also wants to hear back from it.
* This is the prototype of an app that I will develop in the near future. Some of the features of this may be applied in the full app.
    
