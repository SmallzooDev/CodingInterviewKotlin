package problems.baekjoon.p11048

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (y, x) = readLine()!!.split(" ").map { it.toInt() }
    val candy: MutableList<MutableList<Int>> = mutableListOf()
    val dp: MutableList<MutableList<Int>> = MutableList(y) {
        MutableList(x) { 0 }
    }

    repeat(y) {
        candy.add(readLine().split(" ").map { it.toInt() }.toMutableList())
    }

    dp[0][0] = candy[0][0]
    for (i in 0 until y) {
        for (j in 0 until x) {
            if (i == 0 && j == 0) {
                continue
            }

            val fromTop = if (i > 0) dp[i - 1][j] else 0
            val fromLeft = if (j > 0) dp[i][j - 1] else 0
            val fromDiagonal = if (i > 0 && j > 0) dp[i - 1][j - 1] else 0

            dp[i][j] = candy[i][j] + max(fromTop, max(fromLeft, fromDiagonal))
        }
    }

    println(dp[y - 1][x - 1])
    close()
}
