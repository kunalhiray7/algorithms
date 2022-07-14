package dynamicprogramming

import java.util.*


class DynamicProgramming {

    /*
    Given coin denominations and total amount, find out the number of ways to make the change.
     */
    fun solveCoinChange(denominations: IntArray, amount: Int): Int {
        if(denominations.contains(amount)) {
            return 1
        }

        var minCoins = amount
        var coins = 0
        for(coin in denominations) {
            if(coin < amount) {
                coins = 1 + solveCoinChange(denominations, amount - coin)
            }
        }

        return -1
    }

    fun coinCombinations(amount: Int, coins: IntArray, index: Int, list: LinkedList<Int>) {
        if (amount == 0) {
            println(list.toString())
            return
        }
        if (amount < 0) return
        for (i in index until coins.size) {
            val coin: Int = coins[i]
            if (amount >= coin) {
                list.add(coin)
                coinCombinations(amount - coin, coins, i, list)
                list.removeLast()
            }
        }
    }
}

fun main() {
    val dynamicProgramming = DynamicProgramming()
    val denominations = intArrayOf(1, 2, 3, 5)
    dynamicProgramming.coinCombinations(7, denominations, 0, LinkedList<Int>())
}
