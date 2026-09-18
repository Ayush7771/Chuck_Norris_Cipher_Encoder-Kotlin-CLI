package chucknorris

fun main() {
    println("Input encoded string:")
    val input = readln()
    println("\nThe result:")
    val chuckNorris = ChuckNorris(input)
    println(chuckNorris.finalResult)
}

class ChuckNorris(input: String) {

    val inputList: List<String> = input.trim().split(" ")
    val binary = StringBuilder()
    val finalResult = StringBuilder()

    init {
        for (i in inputList.indices step 2) {
            repeat(inputList[i + 1].length) {
                binary.append(
                    if (inputList[i] == "0") "1" else "0"
                )
            }
        }
    }


    init {
        var sevenDigit = binary.chunked(7)
        for (i in sevenDigit) {
            finalResult.append(i.toInt(2).toChar())
        }
    }
}