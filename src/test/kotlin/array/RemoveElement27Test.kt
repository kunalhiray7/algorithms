package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElement27Test {

    @Test
    fun testRemoveElement() {
        val testInstance = RemoveElement27()
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val `val` = 2
        val expectedLength = 5
        // Expected array after removal (order of first k elements matters, assuming implementation preserves relative order or just verifying elements not equal to val)
        // The problem description says "It doesn't matter what you leave beyond the returned k (hence they are underscores)."
        // But the provided solution modifies the array in-place and returns the new length.
        
        val result = testInstance.removeElement(nums, `val`)
        
        assertEquals(expectedLength, result)
        
        // Verify that the first k elements are not equal to `val`
        for (i in 0 until result) {
            assert(nums[i] != `val`) { "Element at index $i should not be $`val`" }
        }
    }
}
