package array

/**
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 *
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability
 * of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 *
 *
 * Example 1:
 *
 * Input
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output
 * [null,0]
 *
 * Explanation
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
 * Example 2:
 *
 * Input
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output
 * [null,1,1,1,1,0]
 *
 * Explanation
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
 *
 * Since this is a randomization problem, multiple answers are allowed.
 * All of the following outputs can be considered correct:
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * and so on.
 */
class RandomPickWithWeight528(val w: IntArray) {

    private var callCounter = 0
    private var countArray = IntArray(w.size) { 0 }
    private val freqMap: MutableMap<Int, Int> = mutableMapOf()

    init {
        w.forEach {
            val freq = freqMap.getOrDefault(it, 0)
            freqMap[it] = freq + 1
        }
    }

    // fails when input array has duplicates
    fun pickIndex(): Int {
        val random: Int
        val randomIndex: Int
        val sum = w.sum()

        if (callCounter < sum) {
            random = w.filterIndexed { index, i -> countArray[index] < i * freqMap.getOrDefault(i, 1)  }.random()
            randomIndex = w.indexOf(random)
            countArray[randomIndex]++
        } else {
            countArray = IntArray(w.size) { 0 }
            callCounter = 0
            random = w.random()
            randomIndex = w.indexOf(random)
            countArray[randomIndex]++
        }
        callCounter++

        return randomIndex
    }

    /**
     * WORKING SOLUTION - but hard to understand
     * private val prefixSums: IntArray = IntArray(w.size)
     *     private val totalSum: Int
     *
     *     init {
     *         var sum = 0
     *         for (i in w.indices) {
     *             sum += w[i]
     *             prefixSums[i] = sum
     *         }
     *         totalSum = sum
     *     }
     *
     *     fun pickIndex(): Int {
     *         val target = Random.nextInt(totalSum)
     *         var low = 0
     *         var high = prefixSums.size - 1
     *         while (low < high) {
     *             val mid = low + (high - low) / 2
     *             if (target >= prefixSums[mid]) {
     *                 low = mid + 1
     *             } else {
     *                 high = mid
     *             }
     *         }
     *         return low
     *     }
     */

}

fun main() {
    var classToTest = RandomPickWithWeight528(intArrayOf(1, 3))

    println(classToTest.pickIndex())
    println(classToTest.pickIndex())
    println(classToTest.pickIndex())
    println(classToTest.pickIndex())
    println(classToTest.pickIndex())

    classToTest = RandomPickWithWeight528(intArrayOf(1))
    println(classToTest.pickIndex())

//    classToTest = RandomPickWithWeight528(intArrayOf(10,7,8,10))
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
//    println(classToTest.pickIndex())
}