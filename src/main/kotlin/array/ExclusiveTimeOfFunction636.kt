package array

import java.util.Stack

/**
 * On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.
 *
 * Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.
 *
 * You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.
 *
 * A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
 *
 * Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.
 *
 * Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3,4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
 * Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
 * Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 * Example 2:
 *
 * Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
 * Output: [8]
 * Explanation:
 * Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
 * Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
 * Function 0 (initial call) resumes execution then immediately calls itself again.
 * Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
 * Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of time.
 * So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing.
 * Example 3:
 *
 * Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
 * Output: [7,1]
 * Explanation:
 * Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
 * Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
 * Function 0 (initial call) resumes execution then immediately calls function 1.
 * Function 1 starts at the beginning of time 6, executes 1 unit of time, and ends at the end of time 6.
 * Function 0 resumes execution at the beginning of time 6 and executes for 2 units of time.
 * So function 0 spends 2 + 4 + 1 = 7 units of total time executing, and function 1 spends 1 unit of total time executing.
 */
class ExclusiveTimeOfFunction636 {

    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val functionToCallTimeMap = mutableMapOf<Int, Int>()
        val stack = Stack<String>()
        logs.reversed().forEach { stack.push(it) }
        var prevTime = 0
        var prevId = 0
        var diff = 0
        while (stack.isNotEmpty()) {
            val log = stack.pop().split(":")
            val duration = log[2].toInt()
            val functionId = log[0].toInt()
            diff = duration - prevTime
            functionToCallTimeMap[prevId] = functionToCallTimeMap.getOrDefault(prevId, 0) + diff
            prevTime = duration
            prevId = functionId
        }
        functionToCallTimeMap[prevId] = functionToCallTimeMap.getOrDefault(prevId, 0) + diff

        return functionToCallTimeMap.map { e -> e.value }.toIntArray()
    }

    fun exclusiveTime1(n: Int, logs: List<String>): IntArray {
        val functionToCallTimeMap = mutableMapOf<Int, Int>()
        var diff: Int
        val stack = Stack<FunLog>()
        logs.forEach { l ->
            val log = l.split(":")
            val functionId = log[0].toInt()
            val operation = log[1]
            val duration = log[2].toInt()
            val funLog = FunLog(functionId, duration, operation)
            when (operation) {
                "start" -> {
                    if(stack.isNotEmpty()) {
                        val prevLog = stack.pop()
                        if(prevLog.operation == "start") {
                            diff = duration - prevLog.startTime
                            functionToCallTimeMap[prevLog.id] = functionToCallTimeMap.getOrDefault(prevLog.id, 0) + diff
                        }
                    }
                }

                "end" -> {
                    if(stack.isNotEmpty()) {
                        val prevLog = stack.pop()
                        diff = duration - prevLog.startTime
                        if(prevLog.operation == "start") {
                            functionToCallTimeMap[funLog.id] = functionToCallTimeMap.getOrDefault(funLog.id, 0) + diff + 1
                        } else {
                            functionToCallTimeMap[funLog.id] = functionToCallTimeMap.getOrDefault(funLog.id, 0) + diff
                        }
                    }
                }
            }
            stack.push(funLog)
        }

        return functionToCallTimeMap.map { e -> e.value }.toIntArray()
    }

    fun exclusiveTimeWorking(n: Int, logs: List<String>): IntArray {
        // Work around a bad test case :/
        // See https://leetcode.com/problems/exclusive-time-of-functions/description/comments/2340147
//        if (logs == BAD_TEST_CASE) {
//            return intArrayOf(2, 6, 1)
//        }

        val times = IntArray(n)
        val stack = ArrayDeque<FunctionTime>()

        for (log in logs) {
            val splits = log.split(":")
            val function = splits[0].toInt()
            val op = splits[1]
            val time = splits[2].toInt()

            val last = stack.lastOrNull()

            when (op) {
                "start" -> {
                    if (last != null) {
                        // Let's say we started 0 at time 0
                        // Now we're starting 1 at time 2
                        // Function 0 now has 2 - 0 = 2 exclusive time
                        times[last.function] += time - last.time
                    }
                    stack.addLast(FunctionTime(function, time))
                }

                "end" -> {
                    // We know last must be non-null
                    // Let's say we started function 1 at time 2
                    // Now we're ending it at time 5
                    // The exclusive time is 5 - 2 + 1 = 4
                    times[function] += (time - last!!.time + 1)
                    stack.removeLast()

                    // Let's say we just removed function 1 at time 5
                    // Now function 0 is at the top of the stack
                    // But it only gets exclusive time from time 6
                    // Update the stack so that we reflect this new start
                    // for the exclusive times
                    if (stack.isNotEmpty()) {
                        val toUpdate = stack.removeLast()
                        stack.addLast(toUpdate.copy(time = time + 1))
                    }
                }
            }
        }

        return times
    }

    private data class FunctionTime(
        val function: Int,
        val time: Int,
    )
}

data class FunLog(
    val id: Int,
    val startTime: Int,
    val operation: String
)

fun printArray(array: IntArray) {
    array.forEach { print(it) }
    println()
}

fun main() {
    val classToTest = ExclusiveTimeOfFunction636()

    printArray(classToTest.exclusiveTime1(2, listOf("0:start:0", "1:start:2", "1:end:5", "0:end:6")))
    printArray(classToTest.exclusiveTime1(1, listOf("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")))
    printArray(classToTest.exclusiveTime1(2, listOf("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")))
    printArray(classToTest.exclusiveTime1(2, listOf("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")))
    printArray(classToTest.exclusiveTime1(1, listOf("0:start:0","0:end:0")))
}