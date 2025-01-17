package strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MinSwapsToMakeStringBalancedTest {

    @ParameterizedTest
    @CsvSource(
            "][][, 1",
            "[], 0",
            "]]][[[, 2",
    )
    fun `should return min swaps required to balance the string`(s: String, expected: Int) {
        assertEquals(expected, MinSwapsToMakeStringBalanced().minSwapsOptimized(s))
    }
}