package com.algorithm.bestTimeForStock

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
class BestTimeToBuyStock {

    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var profit = 0

        for (sell in 1 until prices.size) {
            if (prices[sell] > buy) {
                profit = maxOf(profit, prices[sell] - buy)
            } else {
                buy = prices[sell]
            }
        }

        return profit
    }

    fun maxProfitWithBuyAndSell(prices: IntArray): Int {
        var buyIndex = 0
        var sellIndex = 0
        var maxProfit = 0
        prices.forEachIndexed { index, i ->
            if (index != buyIndex && i > prices[buyIndex]) {
                val profit = i - prices[buyIndex]
                if(profit > maxProfit) {
                    maxProfit = profit
                    sellIndex = index
                }
            } else {
                buyIndex = index
            }
        }
        println("Buy at ${prices[buyIndex]} and sell at ${prices[sellIndex]}")
        return prices[sellIndex] - prices[buyIndex]
    }

    fun minLoss(prices: IntArray): Int {
        var loss = Int.MAX_VALUE
        var buySellPair = Pair(-1, -1)
        for (p in 1 until prices.size) {
            if (prices[p - 1] - prices[p] < loss) {
                loss = prices[p - 1] - prices[p]
                buySellPair = Pair(prices[p - 1], prices[p])
            }
        }
        println("Buy at ${buySellPair.first} and sell at ${buySellPair.second}")
        return loss
    }
}

fun main() {
    val bestTimeToBuyStock = BestTimeToBuyStock()
//    println(bestTimeToBuyStock.maxProfitWithBuyAndSell(intArrayOf(7, 1, 5, 3, 6, 4)))
//    println(bestTimeToBuyStock.maxProfitWithBuyAndSell(intArrayOf(7, 6, 4, 3, 1)))
    println(bestTimeToBuyStock.maxProfitWithBuyAndSell(intArrayOf(2, 7, 16, 4, 3, 2, 1, 8, 9)))
//    println(bestTimeToBuyStock.minLoss(intArrayOf(7, 6, 4, 3, 1)))
//    println(bestTimeToBuyStock.minLoss(intArrayOf(7, 4, 3, 2, 1)))
//    println(bestTimeToBuyStock.minLoss(intArrayOf(10, 7, 5, 4, 1)))
//    println(bestTimeToBuyStock.minLoss(intArrayOf(10, 7, 8, 4, 1)))
}
