package com.example.applist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lv_item.view.*

import java.util.ArrayList
import java.util.Locale

class WordsAdapter(context: Context,
                       list: ArrayList<Word>,
                       val onItemClickListener:((anime:Word) -> Unit) ) : RecyclerView.Adapter<WordsAdapter.MyViewHolder?>() {

    private var mContext = context
    private var mList = list
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mlayoutInflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mView = mlayoutInflater.inflate(R.layout.lv_item,parent,false)
        return MyViewHolder(mView,onItemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindWord(mList[position])
        setAnimation(holder.itemView, position)
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation: Animation =
                AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    override fun getItemCount() = mList.count()

    inner class MyViewHolder(itemView:View,
                             private val onItemClickListener: ((word: Word) -> Unit)) :RecyclerView.ViewHolder(itemView){

        private var name: TextView = itemView.name
        fun bindWord(word: Word) {

            name.text = word.word

            itemView.setOnClickListener{
                onItemClickListener.invoke(word)
            }
        }
    }
}
