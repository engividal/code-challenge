package com.example.applist

import kotlin.collections.ArrayList

class FindWords {

    fun getWords(query: String, listWord: ArrayList<Word>): ArrayList<Word> {

        var result = ArrayList<Word>()

        for (word in listWord) {
            if (partialPermutation(query, word.word)){
                result.add(word)
            }

            if (checkTypos(query, word.word)){
                result.add(word)
            }
        }

        return result
    }

    private fun checkTypos(s: String, t: String): Boolean {
        // degenerate cases
        if (s == t) return true
        if (s == "") return false
        if (t == "") return false

        // create two integer arrays of distances and initialize the first one
        val v0 = IntArray(t.length + 1) { it }  // previous
        val v1 = IntArray(t.length + 1)         // current

        var cost: Int
        for (i in 0 until s.length) {
            // calculate v1 from v0
            v1[0] = i + 1
            for (j in 0 until t.length) {
                cost = if (s[i] == t[j]) 0 else 1
                v1[j + 1] = Math.min(v1[j] + 1, Math.min(v0[j + 1] + 1, v0[j] + cost))
            }
            // copy v1 to v0 for next iteration
            for (j in 0..t.length) v0[j] = v1[j]
        }

        return v1[t.length] <= 1
    }
    private fun partialPermutation(source: String, dest: String): Boolean{
        //­ The first letter hasn’t changed place
        if(source[0] != dest[0]){
            return false
        }

        // If the size of the arrays are different
        if(source.length != dest.length){
            return false
        }

        var jumbled = 0
        for ((index, value) in source.withIndex()){
            val indexDest = dest.indexOf(value)

            if ( indexDest != index ){
                jumbled ++
            }

            // If the character does not exist
            if ( indexDest == -1 ){
                return false
            }
        }
        // If word has more than 3 letters, up to 2/3 of the letters have changed place
        val len = source.length
        if (len > 3){
            return jumbled <= (len * 2/3)
        } else {
            return jumbled > 0
        }
    }
}