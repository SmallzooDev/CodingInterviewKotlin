package problems.baekjoon.p30802

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readln().toInt()
    val cnt = readLine()!!.split(" ").map { it.toInt() }
    val (t, p) = readLine()!!.split(" ").map { it.toInt() }

    val tCount = cnt.fold(0) { acc, count ->
        acc + when {
            count == 0 -> 0
            count % t == 0 -> count / t
            else -> count / t + 1
        }
    }

    println(tCount)
    println("${n / p} ${n % p}")
}
