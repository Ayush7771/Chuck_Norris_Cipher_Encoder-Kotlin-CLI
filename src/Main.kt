package chucknorris

fun main() {
    val input = readln()
    val chuckNorris = ChuckNorris(input)
    chuckNorris.converttoBinary()
    println(chuckNorris.binary)
}

class ChuckNorris(input: String) {

    val inputList: List<String> = input.split(" ")

    val binary = StringBuilder()

    fun converttoBinary() {
        for (i in inputList.indices step 2) {
            if (inputList[i] == "00") {
                repeat(inputList[i + 1].length) {
                    binary.append("0")
                }
            }

            if (inputList[i] == "0") {
                repeat(inputList[i + 1].length) {
                    binary.append("1")
                }
            }


        }
    }

    val finalResult = StringBuilder()


}
