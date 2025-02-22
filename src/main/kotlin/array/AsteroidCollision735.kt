package array

import java.util.Stack
import kotlin.math.abs

/**
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array
 * represent their relative position in space.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right,
 * negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
class AsteroidCollision735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        // - left + right
        // same direction will never meet
        // same size -> both explore
        // smaller -> explore
        val stack = Stack<Int>()
        for(num in asteroids) {
            if(num >= 0) {
                stack.push(num)
            } else {
                while(stack.isNotEmpty() && stack.peek() >= 0 && stack.peek() < abs(num)) {
                    stack.pop()
                }

                when {
                    stack.isEmpty() || stack.peek() < 0 -> stack.push(num)
                    // same size -> explore both
                    stack.peek() == abs(num) -> stack.pop()
                }
            }
        }

        val result = IntArray(stack.size)
        for(index in result.lastIndex downTo 0) {
            result[index] = stack.pop()
        }
        return result
    }
}

fun main() {
    val classToTest = AsteroidCollision735()

    println(classToTest.asteroidCollision(intArrayOf(5, 10, -5)).contentToString())
    println(classToTest.asteroidCollision(intArrayOf(8, -8)).contentToString())
    println(classToTest.asteroidCollision(intArrayOf(10, 2, -5)).contentToString())
    println(classToTest.asteroidCollision(intArrayOf(-8, 8)).contentToString())
    println(classToTest.asteroidCollision(intArrayOf(-2,-1,1,2)).contentToString())
}