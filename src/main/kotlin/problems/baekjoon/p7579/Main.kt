package problems.baekjoon.p7579

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val firstLine = readLine()!!.split(" ").map { it.toInt() }

    val target = firstLine[1];
    val capa = readLine()!!.split(" ").map { it.toInt() }
    val cost = readLine()!!.split(" ").map { it.toInt() }

    val maxCost = cost.sum();
    val dp = MutableList(maxCost + 1) { 0 }

    for (i in 0 until capa.size) {
        for (j in maxCost downTo cost[i]) {
            dp[j] = max(dp[j], dp[j - cost[i]] + capa[i])
        }
    }

    var answer = Int.MAX_VALUE
    for (cost in 0..maxCost) {
        if (dp[cost] >= target) {
            answer = min(answer, cost)
        }
    }

    println("$answer")
    close()
}
