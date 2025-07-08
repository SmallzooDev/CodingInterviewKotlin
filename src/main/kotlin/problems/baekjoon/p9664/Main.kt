package problems.baekjoon.p9664

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val remains = readLine().toInt()

    val q0 = remains / (n - 1)
    val r0 = remains % (n - 1)

    val (minQ, maxQ) = if (r0 == 0 && q0 >= 1) {
        Pair(q0 - 1, q0)
    } else {
        Pair(q0, q0)
    }

    val minTotal = remains + minQ
    val maxTotal = remains + maxQ

    println("$minTotal $maxTotal")
    close()
}