package problems.baekjoon.p9251

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val firstString = readLine()!!.toCharArray()
    val secondString = readLine()!!.toCharArray()

    val m = firstString.size
    val n = secondString.size
    val dp = MutableList(m + 1) {
        MutableList(n + 1) { 0 }
    }

    for (i in 1 until m + 1) {
        for (j in 1 until n + 1) {
            if (firstString[i - 1] == secondString[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[m][n])
    close()
}
