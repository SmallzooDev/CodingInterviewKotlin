package problems.baekjoon.p11050

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    println(bc(a, b))
    close()
}

fun bc(n: Int, k: Int): Long {
    if (k > n || k < 0) return 0
    if (k == 0 || k == n) return 1

    val target = if (k > n - k) n - k else k

    var result = 1L
    for (i in 0 until target) {
        result = result * (n - i) / (i + 1)
    }
    return result
}