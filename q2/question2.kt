// 2. Check words with jumbled letters :
// Our brain can read texts even if letters are jumbled, like the following sentence: “Yuo
// cna porbalby raed tihs esaliy desptie teh msispeillgns.” Given two strings, write a
// method to decide if one is a partial­permutation of the other. Consider a
// partial­permutation only if:
//­ The first letter hasn’t changed place
// If word has more than 3 letters, up to 2/3 of the letters have changed place
// Examples:
// you, yuo ­> true
// probably, porbalby ­> true
// despite, desptie ­> true
// moon, nmoo ­> false
// misspellings, mpeissngslli ­> false


fun main(args: Array<String>) {

    println(partialPermutation("you", "yuo"))
    println(partialPermutation("probably", "porbalby"))
    println(partialPermutation("despite", "desptie"))
    println(partialPermutation("moon", "nmoo"))
    println(partialPermutation("misspellings", "msispeillgns"))
}

fun partialPermutation(source: String, dest: String): Boolean{
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
    if(jumbled > (len * 2/3)){
        print(jumbled)
        return false
    }else{
        return true
    }
}
