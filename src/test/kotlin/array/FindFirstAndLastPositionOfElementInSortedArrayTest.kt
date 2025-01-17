package array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindFirstAndLastPosition {

    @Test
    fun `should return result`() {
        val findFirstAndLastPositionOfElementInSortedArray = FindFirstAndLastPositionOfElementInSortedArray()
        assertArrayEquals(intArrayOf(3, 4), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8))
        assertArrayEquals(intArrayOf(-1, -1), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6))
        assertArrayEquals(intArrayOf(0, 0), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 5))
        assertArrayEquals(intArrayOf(5, 5), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 10))
        assertArrayEquals(intArrayOf(0, 5), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5, 5, 5, 5, 5, 5), 5))
        assertArrayEquals(intArrayOf(0, 0), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5), 5))
        assertArrayEquals(intArrayOf(-1, -1), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5), 6))
        assertArrayEquals(intArrayOf(-1, -1), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(5), 4))
        assertArrayEquals(intArrayOf(-1, -1), findFirstAndLastPositionOfElementInSortedArray.searchRange(intArrayOf(), 4))
    }
}