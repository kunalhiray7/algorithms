package strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class HappyStringTest {

    @ParameterizedTest
    @CsvSource(
        "1, 1, 7, ccaccbcc",
        "7, 1, 0, aabaa"
    )
    fun `should return maximum length happy string`(a: Int, b: Int, c: Int, expected: String) {
        assertEquals(expected, HappyString().longestDiverseString(a, b, c))
    }
}