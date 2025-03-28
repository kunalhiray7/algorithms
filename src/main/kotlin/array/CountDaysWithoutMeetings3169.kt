package array

/**
 * You are given a positive integer days representing the total number of days an employee is available for work
 * (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i]
 * represents the starting and ending days of meeting i (inclusive).
 *
 * Return the count of days when the employee is available for work but no meetings are scheduled.
 *
 * Note: The meetings may overlap.
 *
 * Example 1:
 *
 * Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
 *
 * Output: 2
 *
 * Explanation:
 *
 * There is no meeting scheduled on the 4th and 8th days.
 *
 * Example 2:
 *
 * Input: days = 5, meetings = [[2,4],[1,3]]
 *
 * Output: 1
 *
 * Explanation:
 *
 * There is no meeting scheduled on the 5th day.
 */
class CountDaysWithoutMeetings3169 {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        val visited = mutableMapOf<Int, Boolean>()
        meetings.forEach {
            for (i in it[0] until it[1] + 1) {
                visited[i] = true
            }
        }
        var count = 0
        for (i in 1 until days + 1) {
            if (!visited.getOrDefault(i, false)) {
                count++
            }
        }
        return count
    }

    fun countDaysOptimized(days: Int, meetings: Array<IntArray>): Any {
        val meetingDays = meetings.flatMap { (start, end) -> (start..end).toList() }.toSet()
        return (1..days).count { it !in meetingDays }
    }
}

fun main() {
    val testClass = CountDaysWithoutMeetings3169()
    println(testClass.countDaysOptimized(10, arrayOf(intArrayOf(5, 7), intArrayOf(1, 3), intArrayOf(9, 10))))
    println(testClass.countDaysOptimized(5, arrayOf(intArrayOf(2, 4), intArrayOf(1, 3))))
}