//package chucknorris
fun main(){
    println("Input string:")
    val input = readln()
    val finalbinary = StringBuilder()
    for (i in input) {
        val charToBinary = i.code.toString(2).toInt()
        val binary = "%07d".format(charToBinary)
        finalbinary.append(binary)
    }
    println("\nThe result:")
    println(finalbinary)
}