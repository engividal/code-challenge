// 1. Replacing characters in place:
// Given an array of characters, write a method to replace all the spaces with “&32”.
// You may assume that the array has sufficient slots at the end to hold the additional
// characters, and that you are given the “true” length of the array. (Please perform this
// operation in place with no other auxiliary structure).
// Example:
// Input: “User is not allowed “, 19
// Output: “User&32is&32not&32allowed”

fun main(args: Array<String>) {
    var array = "User is not allowed      ".toCharArray() 
    
    println(array)
    replaceSpace(array)
}

fun replaceSpace(str: CharArray){

    while(str.contains(' ')){
        val spaceIndex = str.indexOf(' ')
        
        val spaces = {s: Char -> s != ' '}
        
        val lastChar = str.indexOfLast(spaces)
        
        for (i in lastChar downTo spaceIndex){
            str[i + 2] = str[i]   
        }
        
        str[spaceIndex] = '&'
        str[spaceIndex + 1] = '3'
        str[spaceIndex + 2] = '2'

    }


    println(str)
}
