package array

import java.util.PriorityQueue
import kotlin.math.sqrt

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
class KClosestPointsToOrigin973 {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val priorityQueue = PriorityQueue<Pair<Double, IntArray>>(Comparator { o1, o2 -> o1.first.compareTo(o2.first) })
        points.forEach { point ->
            val distance = sqrt(point[0].toDouble() * point[0] + point[1] * point[1])
            priorityQueue.add(distance to point)
        }
        val result = Array<IntArray>(k) { intArrayOf() }
        for (i in 0 until k) {
            result[i] = priorityQueue.poll().second
        }

        return result
    }

}

fun main() {
    val classToTest = KClosestPointsToOrigin973()

    println(classToTest.kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1))
    println(classToTest.kClosest(arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2))
}