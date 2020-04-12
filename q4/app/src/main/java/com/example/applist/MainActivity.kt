package com.example.applist

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    // Declare Variables
    private val mFindWords = FindWords()
    var wordNamesArrayList = arrayListOf<Word>()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnQueryTextListener(this)

        wordNamesArrayList = getAll()
        with(rv_name){
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL,false)
            setHasFixedSize(true)

            adapter = WordsAdapter(this@MainActivity, wordNamesArrayList){ word ->
                Toast.makeText(
                    this@MainActivity,
                    word.word,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fab.setOnClickListener { view ->
            wordNamesArrayList.clear()
            wordNamesArrayList.addAll(getAll())
            rv_name.adapter!!.notifyDataSetChanged()
            Snackbar.make(view, "List has been reset!", Snackbar.LENGTH_SHORT)
                .setAction("Ok", null)
                .show()
        }

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            wordNamesArrayList.clear()
            wordNamesArrayList.addAll(mFindWords.getWords(query, getAll()))
            rv_name.adapter!!.notifyDataSetChanged()
        }
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //rv_name.adapter!!.li
        return false
    }

    fun getAll(): ArrayList<Word> {
        var arrayList = arrayListOf<Word>()
        arrayList.add(Word("ple"))
        arrayList.add(Word("pale"))
        arrayList.add(Word("bale"))
        arrayList.add(Word("bake"))
        arrayList.add(Word("yuo"))
        arrayList.add(Word("porbalby"))
        arrayList.add(Word("desptie"))
        arrayList.add(Word("nmoo"))
        arrayList.add(Word("mpeissngslli"))

        return arrayList
    }
}