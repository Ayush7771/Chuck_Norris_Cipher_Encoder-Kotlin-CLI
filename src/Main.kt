//package chucknorris
fun main() {
    println("Input string:")

    val input = readln()

    val finalbinary = StringBuilder()

    for (i in input) {
        val charToBinary = i.code.toString(2).toInt()
        val binary = "%07d".format(charToBinary)
        finalbinary.append(binary)
    }

    println("\nThe result:")

    val temp = StringBuilder()
    val finalResult = StringBuilder()

    for (index in finalbinary.indices) {
        if (index == 0) {
            temp.append(finalbinary[0])
            continue
        }

        if (finalbinary[index - 1] == finalbinary[index]) {
            temp.append(finalbinary[index])
        } else if (finalbinary[index - 1] != finalbinary[index]){
            finalResult.append("${if (temp.last() == '0') "00" else "0"} ")
            repeat(temp.length) {
                finalResult.append("0")
            }
            finalResult.append(" ")
            temp.clear()
            temp.append(finalbinary[index])
        }

        if (index == finalbinary.lastIndex){
            finalResult.append("${if (temp.last() == '0') "00" else "0"} ")
            repeat(temp.length) {
                finalResult.append("0")
            }
        }


    }

    println(finalResult)
}