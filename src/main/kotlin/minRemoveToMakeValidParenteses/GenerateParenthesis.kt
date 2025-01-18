package minRemoveToMakeValidParenteses

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 */
class GenerateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtrack(result, "", 0, 0, n)
        return result
    }

    private fun backtrack(result: MutableList<String>, s: String, i: Int, j: Int, n: Int) {
        if (s.length == n * 2) {
            result.add(s)
            return
        }

        if (i < n) {
            backtrack(result, "$s(", i + 1, j, n)
        }

        if (j < i) {
            backtrack(result, "$s)", i, j + 1, n)
        }
    }
}

fun main() {
    val classToTest = GenerateParenthesis()

    println(classToTest.generateParenthesis(3))
    println(classToTest.generateParenthesis(1))
}