package problems.baekjoon.p2293

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val coins = IntArray(n)
    for (i in 0 until n) {
        coins[i] = readLine().toInt()
    }

    val dp = IntArray(k + 1)
    dp[0] = 1

    for (coin in coins) {
        for (i in coin..k) {
            dp[i] += dp[i - coin]
        }
    }

    println(dp[k])
    close()
}