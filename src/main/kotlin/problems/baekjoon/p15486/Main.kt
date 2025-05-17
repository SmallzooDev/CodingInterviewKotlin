package problems.baekjoon.p15486

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val days = mutableListOf<Int>()
    val costs = mutableListOf<Int>()

    repeat(n) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }
        days.add(tmp[0])
        costs.add(tmp[1])
    }

    val dp = MutableList(n + 1) { 0 }
    var maxProfit = 0;

    for (i in 0 until n) {
        maxProfit = max(maxProfit, dp[i])

        val end = i + days[i]
        if (end <= n) {
            dp[end] = max(dp[end], maxProfit + costs[i])
        }
    }


    val output = max(maxProfit, dp[n])
    println("$output")
    close()
}
