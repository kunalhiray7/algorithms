package array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CombinationSumTest {

    @ParameterizedTest
    @MethodSource("parametersForCombinationSum")
    fun `should return combination sum`(candidates: IntArray, target: Int, expected: List<List<Int>>) {
        val combinationSum = CombinationSumSolution()
        assertEquals(expected, combinationSum.combinationSum(candidates, target))
    }

    companion object {
        @JvmStatic
        fun parametersForCombinationSum() = listOf(
            arrayOf(intArrayOf(2, 3, 6, 7), 7, listOf(listOf(2, 2, 3), listOf(7))),
            arrayOf(intArrayOf(2, 3, 5), 8, listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))),
            arrayOf(intArrayOf(2), 1, emptyList<List<Int>>()),
        )
    }
}
