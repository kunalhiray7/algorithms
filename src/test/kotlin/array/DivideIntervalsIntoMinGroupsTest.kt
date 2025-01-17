package array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DivideIntervalsIntoMinGroupsTest {

    private val toTest = DivideIntervalsIntoMinGroups()

    @Test
    fun `should return the min no of groups`() {
        assertEquals(1, toTest.minGroups(arrayOf(intArrayOf(1,3), intArrayOf(5, 6), intArrayOf(8, 10),
                intArrayOf(11, 13))))

        assertEquals(3, toTest.minGroups(arrayOf(intArrayOf(5,10), intArrayOf(6, 8), intArrayOf(1, 5),
                intArrayOf(2, 3), intArrayOf(1,10))))

    }
}