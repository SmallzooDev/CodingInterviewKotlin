package problems.baekjoon.p1978

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    println(
        readLine()!!.split(" ").map { it.toInt() }.count { it.isPrime() }
    )
    close()
}

private fun Int.isPrime(): Boolean {
    if (this < 2) return false
    if (this == 2) return true
    if (this % 2 == 0) return false

    val limit = sqrt(this.toDouble()).toInt()
    for (i in 3..limit step 2) {
        if (this % i == 0) return false
    }

    return true
}