package trees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfProvince547Test {

    private val solution = NumberOfProvince547()

    @Test
    fun testExample1() {
        val isConnected = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(2, solution.findCircleNum(isConnected))
    }

    @Test
    fun testExample2() {
        val isConnected = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, solution.findCircleNum(isConnected))
    }

    @Test
    fun testConnectedNode2() {
        val isConnected = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 0, 1)
        )
        // 0 is connected to 2. {0, 2} is one province. {1} is another. Total 2.
        assertEquals(2, solution.findCircleNum(isConnected))
    }
}
