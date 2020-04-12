package com.example.applist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    // Declare Variables
    private var list: ListView? = null
    private var adapter: ListViewAdapter? = null
    private var editsearch: SearchView? = null
    private var wordList: Array<String>? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate sample data
        wordList = arrayOf(
            "Xmen",
            "Titanic",
            "Captain America",
            "Iron man",
            "Rocky",
            "Transporter",
            "Lord of the rings",
            "The jungle book",
            "Tarzan",
            "Cars",
            "Shreck"
        )

        // Locate the ListView in listview_main.xml
        list = findViewById(R.id.listview) as ListView

        wordNamesArrayList = ArrayList()

        for (i in wordList!!.indices) {
            val movieNames = Words(wordList!![i])
            // Binds all strings into an array
            wordNamesArrayList.add(movieNames)
        }

        // Pass results to ListViewAdapter Class
        adapter = ListViewAdapter(this)

        // Binds the Adapter to the ListView
        list!!.adapter = adapter

        // Locate the EditText in listview_main.xml
        editsearch = findViewById(R.id.search) as SearchView
        editsearch!!.setOnQueryTextListener(this)

        list!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this@MainActivity,
                wordNamesArrayList[position].getWord(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {

        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //adapter!!.filter(newText)
        return false
    }

    companion object {
        var wordNamesArrayList = ArrayList<Words>()
    }
}
