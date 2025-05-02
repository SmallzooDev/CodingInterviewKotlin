package problems.baekjoon.p11053

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val inputs = readLine()!!.split(" ").map { it.toInt() }
    val dp = MutableList(n) { 1 }

    for (i in 1 until inputs.size) {
        for (j in 0 until i) {
            if (inputs[i] > inputs[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    println(dp.max())
    close()
}
