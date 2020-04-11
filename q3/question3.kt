// 3. Check words with typos:
// There are three types of typos that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to
// check if they are one typo (or zero typos) away.
// Examples:
// pale, ple ­> true
// pales, pale ­> true
// pale, bale ­> true
// pale, bake ­> false

// https://www.cuelogic.com/blog/the-levenshtein-algorithm
fun main(args: Array<String>) {

    println(checkTypos("pale", "ple")) //true
    println(checkTypos("pales", "pale")) //true
    println(checkTypos("pale", "bale")) //true
    println(checkTypos("pale", "bake")) //false
    println(checkTypos("HONDA", "HYUNDAI")) //false

}

fun checkTypos(s: String, t: String): Boolean {
    // degenerate cases
    if (s == t)  return true
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
        for (j in 0 .. t.length) v0[j] = v1[j]
    }

    if(v1[t.length]>1){
        return false
    }else{
        return true
    }
}