package strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MinStringLengthAfterRemovingSubstringTest {

    @ParameterizedTest
    @CsvSource(
            "ABFCACDB, 2",
            "ACBBD, 5",
            "D, 1",
            "B, 1",
            "A, 1",
            "C, 1",
    )
    fun `should return length of reduced string after removing substring`(s: String, expected: Int) {
        assertEquals(expected, MinStringLengthAfterRemovingSubstring().minLengthOptimized(s))
    }
}