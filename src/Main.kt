package chucknorris

fun main() {
    while (true) {
        println("Please input operation (encode/decode/exit):")
        val actionInput = readln()
        when (actionInput.lowercase()) {
            "encode" -> println(encode())
            "decode" -> println(decode())
            "exit" -> {
                println("Bye!")
                break
            }
            else -> println("There is no '$actionInput' operation\n")
        }
    }
}

fun encode() : String {
    println("Input string:")

    val input = readln()

    val binary = StringBuilder()

    for (char in input){
        val charToBinary = char.code.toString(2).toInt()
        binary.append("%07d".format(charToBinary))
    }

    val encodedString = StringBuilder()
    var count = 1
    for (char in 1..binary.length){
        if (char < binary.length && binary[char] == binary[char -1]){
            count++
        } else{
            encodedString.append(if (binary[char - 1] == '0') "00 " else "0 ")
            repeat(count){encodedString.append("0")}
            encodedString.append(" ")
            count = 1
        }
    }

    return "Encoded string:\n${encodedString.trim()}\n"
}

fun decode(): String {
    println("Input encoded string:")
    val input = readln()
    val inputList: List<String> = input.trim().split(" ")

    if (inputList.size % 2 == 1) {
        return "Encoded string is not valid.\n"
    }
    val binary = StringBuilder()
    val finalResult = StringBuilder()

    for (i in inputList.indices step 2) {
        if (listOf("0", "00").contains(inputList[i])) {
            repeat(inputList[i + 1].length) {
                binary.append(
                    if (inputList[i] == "0") "1" else "0"
                )
            }
        } else {
            return "Encoded string is not valid.\n"
        }
    }

    if (binary.length % 7 != 0) return "Encoded string is not valid.\n"

    val sevenDigit = binary.chunked(7)
    for (i in sevenDigit) {
        finalResult.append(i.toInt(2).toChar())
    }

    return "Decoded string:\n$finalResult\n"
}