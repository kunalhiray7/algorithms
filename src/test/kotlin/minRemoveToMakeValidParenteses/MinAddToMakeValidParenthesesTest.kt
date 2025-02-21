package minRemoveToMakeValidParenteses

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import parenthesis.MinAddToMakeValidParentheses

class MinAddToMakeValidParenthesesTest {

    @ParameterizedTest
    @CsvSource(
            "()), 1",
            "(((, 3",
            "(((), 2",
            "((())(, 2",
            "()))((, 4",
            "))(((())(, 5",
    )
    fun `should return min addition to make a valid parentheses`(input: String, expected: Int) {
        assertEquals(expected, MinAddToMakeValidParentheses().minAddToMakeValid(input))
    }
}