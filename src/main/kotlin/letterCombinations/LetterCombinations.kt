package letterCombinations

class LetterCombinations {
    /*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     */

    private val keyToLetters = mapOf(
        "2" to listOf("a", "b", "c"),
        "3" to listOf("d", "e", "f"),
        "4" to listOf("g", "h", "i"),
        "5" to listOf("j", "k", "l"),
        "6" to listOf("m", "n", "o"),
        "7" to listOf("p", "q", "r", "s"),
        "8" to listOf("t", "u", "v"),
        "9" to listOf("w", "x", "y", "z"),
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) {
            return emptyList()
        }

        val toCharArray = digits.toCharArray()
        val result = mutableListOf<String>()
        result.addAll(keyToLetters[toCharArray[0].toString()]!!)

        for (i in 1 until toCharArray.size) {
            val temp = mutableListOf<String>()
            for (j in result) {
                for (k in keyToLetters[toCharArray[i].toString()]!!) {
                    temp.add(j + k)
                }
            }
            result.clear()
            result.addAll(temp)
        }

        return result
    }
}

fun main() {
    println(LetterCombinations().letterCombinations("23"))
}
