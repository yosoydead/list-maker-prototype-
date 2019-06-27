* The name of this project is: ListMaker. It will be a to-do list organizer. (book **Android apprentice**)
* This app will use a **RecyclerView** instead of a ListView.
* Step I:
    * 1. [x] **content_main.xml** is the actual layout that contains the initial TextView (it is imported into the **activity_main.xml**). Open it and replace the TextView with a **RecyclerView**. 
    * 2. [ ] Implement the RecyclerView **Adapter** and **ViewHolder**. These are required components in order to make the RecyclerView functional.
        * The RecyclerView asks the **Adapter** for an item, or a **ViewHolder** at a given position
        * The **Adapter** gives the RecyclerView data it wants to show
        * The **ViewHolders** are the visual containers for the item. You tell the RecyclerView how each item should look like
        * The **Adapter** reaches into the pool of **ViewHolders** that have been created
        * Either a new **ViewHolder** is returned or a new one is created
        * The **Adapter** then binds this **ViewHolder** to a data item at the given position
        * The **ViewHolder** is returned back to the RecyclerView for display
