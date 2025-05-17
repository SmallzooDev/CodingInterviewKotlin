package problems.baekjoon.p1106

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val firstLine = readLine()!!.split(" ").map { it.toInt() }
    val target = firstLine[0]
    val cnt = firstLine[1]

    val costs = mutableListOf<Pair<Int, Int>>()

    repeat(cnt) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }
        costs.add(Pair(tmp[0], tmp[1]))
    }
    val maxVal = target * 2
    val dp = MutableList(maxVal) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 0 until maxVal) {
        if (dp[i] == Int.MAX_VALUE) {
            continue
        }

        for ((cost, customers) in costs) {
            val next = i + customers
            if (next <= maxVal) {
                dp[next] = min(dp[next], dp[i] + cost)
            }
        }
    }

    var minCost = Int.MAX_VALUE
    for (i in target..maxVal) {
        if (dp[i] != Int.MAX_VALUE) {
            minCost = min(minCost, dp[i])
        }
    }
    println(minCost)
    close()
}
