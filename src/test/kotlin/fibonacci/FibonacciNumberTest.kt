package fibonacci

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FibonacciNumberTest {

    @Test
    fun `should return n fibonacci number`() {
        val fibonacciNumber = FibonacciNumber()
        assertEquals(1346269, fibonacciNumber.climbStairs(30))
        assertEquals(2178309, fibonacciNumber.climbStairs(31))
        assertEquals(3524578, fibonacciNumber.climbStairs(32))
//        assertEquals(1, fibonacciNumber.climbStairs(0))
//        assertEquals(1, fibonacciNumber.climbStairs(1))
//        assertEquals(2, fibonacciNumber.climbStairs(2))
//        assertEquals(3, fibonacciNumber.climbStairs(3))
//        assertEquals(5, fibonacciNumber.climbStairs(4))
//        assertEquals(8, fibonacciNumber.climbStairs(5))
//        assertEquals(13, fibonacciNumber.climbStairs(6))
//        assertEquals(21, fibonacciNumber.climbStairs(7))
//        assertEquals(34, fibonacciNumber.climbStairs(8))
//        assertEquals(55, fibonacciNumber.climbStairs(9))
        assertEquals(14930352, fibonacciNumber.climbStairs(35))
    }
}
