package fibonacci

class FibonacciNumber {

    private var memo = IntArray(31)

    fun climbStairs(n: Int): Int {
        if (memo.size <= n + 1) {
            memo = memo.copyOf(n * 2)
        } else if (memo[n + 1] != 0) {
            return memo[n + 1]
        }
        return fibonacciDynamic(n + 1)
    }

    private fun fibonacciDynamic(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        memo[0] = 0
        memo[1] = 1
        for (i in 2..n) {
            memo[i] = memo[i - 1] + memo[i - 2]
        }
        return memo[n]
    }
}
