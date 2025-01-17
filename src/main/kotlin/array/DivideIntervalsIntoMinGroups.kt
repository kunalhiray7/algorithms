package array

import java.util.*

/**
 * You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
 *
 * You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
 *
 * Return the minimum number of groups you need to make.
 *
 * Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
 * Output: 3
 * Explanation: We can divide the intervals into the following groups:
 * - Group 1: [1, 5], [6, 8].
 * - Group 2: [2, 3], [5, 10].
 * - Group 3: [1, 10].
 * It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
 * Example 2:
 *
 * Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
 * Output: 1
 * Explanation: None of the intervals overlap, so we can put all of them in one group.
 *
 */
class DivideIntervalsIntoMinGroups {

    fun minGroupsWorking(intervals: Array<IntArray>): Int {
        // sort `intervals` using the interval start
        intervals.sortBy { it[0] }

        // init a PQ to store the end bounds of groups
        // (use PQ instead of List: auto-sort the biggest end bound into the end)
        val endBounds = PriorityQueue<Int>()

        // add first group (contains first interval)
        var groupCount = 1
        endBounds.add(intervals[0][1])

        // loop through the rest intervals to check add groups
        for (i in 1..intervals.size - 1) {
            if (endBounds.peek() < intervals[i][0]) {
                // the last group end bound < this interval start
                // this interval can belong to the last group
                // poll end bound
                endBounds.poll()
                // replace new end bound using this interval end
                endBounds.add(intervals[i][1])
            } else {
                // the last group end bound >= this interval start (intersected)
                // must create a new group for this interval
                groupCount++
                endBounds.add(intervals[i][1])
            }
        }

        return groupCount
    }

    fun minGroups(intervals: Array<IntArray>): Int {
        val groups = mutableListOf<MutableList<IntRange>>()
        groups.add(mutableListOf(intervals[0][0]..intervals[0][1]))
        for (i in 1 .. intervals.size - 1) {
            val overlappingGroup = groups.find { it.any { r -> !r.isOverlapping(intervals[i]) } }
            if (null != overlappingGroup) {
                overlappingGroup.add(intervals[i][0]..intervals[i][1])
            }
            /*else {
                var first = overlappingGroup.first
                var last = overlappingGroup.last
                if (interval[0] <= first) {
                    first = interval[0]
                }
                if (interval[1] >= last) {
                    last = interval[1]
                }
                groups.remove(overlappingGroup)
                groups.add(first..last)
            }*/
        }

        return groups.size
    }
}

fun IntRange.isOverlapping(interval: IntArray): Boolean {
    val minOrNull = this.minOrNull()!!
    val maxOrNull = this.maxOrNull()!!
    return (interval[0] in minOrNull..maxOrNull) ||
            interval[1] in minOrNull..maxOrNull
}