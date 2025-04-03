package strings

class StringCombinations {
    fun combinations(input: String): Set<String> {
        validate(input)
        val combinations = mutableSetOf<String>()

        findPermutations("", input, combinations)

        return combinations
    }

    private fun validate(input: String) {
        require(input.isNotBlank()) { "Input string cannot be blank" }
    }

    private fun findPermutations(prefix: String, remaining: String, combs: MutableSet<String>) {
        if (remaining.isEmpty()) {
            combs.add(prefix)
            return
        }

        for (i in remaining.indices) {
            findPermutations(prefix + remaining[i], remaining.substring(0, i) + remaining.substring(i + 1), combs)
        }
    }

}

fun main() {
    val testClass = StringCombinations()
    println(testClass.combinations("abc"))
    println(testClass.combinations("abcd"))
}