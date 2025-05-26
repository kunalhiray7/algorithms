package graphs

import java.util.*

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 *
 * So it is impossible.
 */
class CourseSchedule207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        val inDegree = IntArray(numCourses)

        // Build the graph and in-degree array
        for (prerequisite in prerequisites) {
            val course = prerequisite[0]
            val preCourse = prerequisite[1]
            graph[preCourse].add(course)
            inDegree[course]++
        }

        // Queue for courses with no prerequisites
        val queue: Queue<Int> = LinkedList()
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) {
                queue.offer(i)
            }
        }

        // Count of courses that can be completed
        var count = 0

        while (queue.isNotEmpty()) {
            val course = queue.poll()
            count++

            // Decrease the in-degree of neighboring courses
            for (neighbor in graph[course]) {
                inDegree[neighbor]--
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor)
                }
            }
        }

        return count == numCourses
    }
}