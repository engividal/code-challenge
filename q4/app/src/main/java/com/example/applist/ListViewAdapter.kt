package com.example.applist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import java.util.ArrayList
import java.util.Locale

class ListViewAdapter(
    // Declare Variables

    internal var mContext: Context) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<Words>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(MainActivity.wordNamesArrayList)
    }

    inner class ViewHolder {
        internal var name: TextView? = null
    }

    override fun getCount(): Int {
        return MainActivity.wordNamesArrayList.size
    }

    override fun getItem(position: Int): Words {
        return MainActivity.wordNamesArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.lv_item, null)
            // Locate the TextViews in listview_item.xml
            holder.name = view!!.findViewById(R.id.name) as TextView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.name!!.setText(MainActivity.wordNamesArrayList[position].getWord())
        return view
    }

    // Filter Class
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        MainActivity.wordNamesArrayList.clear()
        if (charText.length == 0) {
            MainActivity.wordNamesArrayList.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.getWord().toLowerCase(Locale.getDefault()).contains(charText)) {
                    MainActivity.wordNamesArrayList.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

}