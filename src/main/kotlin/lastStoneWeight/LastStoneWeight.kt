package lastStoneWeight

import java.util.*


class LastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue(Collections.reverseOrder<Int>())
        for (st in stones) queue.offer(st)

        while (queue.size > 1) {
            val f = queue.poll()
            val s = queue.poll()
            if (f != s) queue.offer(f - s)
        }

        return if (queue.isEmpty()) 0 else queue.peek()
    }
}

fun main() {
    println(LastStoneWeight().lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}
