package array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SearRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("parametersForTest")
    fun `should search in rotated sorted array`(input: IntArray, target: Int, expectedIndex: Int) {
        val searchInRotatedSortedArray = SearchInRotatedSortedArray()
        assertEquals(expectedIndex, searchInRotatedSortedArray.search(input, target))
    }

    companion object {
        @JvmStatic
        fun parametersForTest() = Stream.of(
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4,),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3, -1),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 4, 0),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5, 1),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 6, 2),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 7, 3),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 1, 5),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 2, 6),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 8, -1),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), -1, -1),
                Arguments.of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 9, -1),
                Arguments.of(intArrayOf(5, 6, 7, 0, 1, 2, 4), -2, -1),
                Arguments.of(intArrayOf(0, 1, 2, 4, 5, 6, 7), -2, -1),
                Arguments.of(intArrayOf(7, 0, 1, 2, 4, 5, 6), -2, -1),
                Arguments.of(intArrayOf(7, 0, 1, 2, 4, 5, 6), -2, -1),
                Arguments.of(intArrayOf(1, 3), 1, 0),
                Arguments.of(intArrayOf(3, 1), 1, 1
                ),
        )
    }
}