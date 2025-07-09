package problems.baekjoon.p2491

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val seq = readLine()!!.split(" ").map { it.toInt() }
    val dpInc = MutableList(n) { 1 }
    val dpDec = MutableList(n) { 1 }

    for (i in 1 until n) {
        if (seq[i] > seq[i-1]) {
            dpInc[i] = dpInc[i - 1] + 1
            dpDec[i] = 1
        } else if (seq[i] < seq[i - 1]) {
            dpInc[i] = 1
            dpDec[i] = dpDec[i - 1] + 1
        } else {
            dpInc[i] = dpInc[i - 1] + 1
            dpDec[i] = dpDec[i - 1] + 1
        }
    }

    val maxInc = dpInc.maxOf { it }
    val maxDec = dpDec.maxOf { it }
    println(maxOf(maxInc, maxDec))
    close()
}
