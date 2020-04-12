package com.example.applist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    // Declare Variables
    private var list: ListView? = null
    private var adapter: ListViewAdapter? = null
    private var editsearch: SearchView? = null
    private val mFindWords = FindWords()
    var wordNamesArrayList = getAll()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.listview) as ListView

        wordNamesArrayList = getAll()
        adapter = ListViewAdapter(this)
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

    override fun onQueryTextSubmit(query: String?): Boolean {
        editsearch!!.clearFocus()
        editsearch!!.setQuery( "",  false)

        if (query != null) {
            var str = mFindWords.getWords(query)
            Toast.makeText(this@MainActivity, str[0], Toast.LENGTH_LONG).show()
            //notifyDataSetChanged()
        }
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //adapter!!.filter(newText)
        return false
    }

    companion object {
        var wordNamesArrayList = ArrayList<Words>()
    }

    fun getAll(): ArrayList<Words> {
        var arrayList = arrayListOf<Words>()
        arrayList.add(Words("ple"))
        arrayList.add(Words("pale"))
        arrayList.add(Words("bale"))
        arrayList.add(Words("bake"))
        arrayList.add(Words("yuo"))
        arrayList.add(Words("porbalby"))
        arrayList.add(Words("desptie"))
        arrayList.add(Words("nmoo"))
        arrayList.add(Words("mpeissngslli"))

        return arrayList
    }
}