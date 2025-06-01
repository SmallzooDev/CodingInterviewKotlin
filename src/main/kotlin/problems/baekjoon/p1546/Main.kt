package problems.baekjoon.p1546

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val scores = readLine()!!.split(" ").map { it.toInt() }
    val maxScore = scores.max()
    println(scores.sum().toDouble() * 100 / (maxScore * scores.size))
    close()
}
