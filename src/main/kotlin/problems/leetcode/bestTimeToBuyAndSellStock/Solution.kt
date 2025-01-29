package problems.leetcode.bestTimeToBuyAndSellStock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var currentMin = Int.MAX_VALUE
        var currentMaxProfit = 0

        prices.forEach {
            if (it < currentMin) {
                currentMin = it
            }

            currentMaxProfit = maxOf(currentMaxProfit, it - currentMin)
        }

        return currentMaxProfit
    }
}
