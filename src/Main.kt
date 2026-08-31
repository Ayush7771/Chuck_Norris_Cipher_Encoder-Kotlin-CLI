//package chucknorris
fun main(){
    println("Input string:")
    val input = readln()
    println("\nThe result:")
    for (i in input) {
        val charToBinary = i.code.toString(2).toInt()
        println("$i = %07d".format(charToBinary))
    }
}