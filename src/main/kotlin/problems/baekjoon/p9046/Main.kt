package problems.baekjoon.p9046

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        val charCount = readLine()!!
            .filter { it != ' ' }
            .groupBy { it }
            .mapValues { it.value.size }

        val maxCount = charCount.maxOf { it.value }
        val candidates = charCount.filter { it.value == maxCount }

        println(if (candidates.size > 1) "?" else candidates.keys.first())
    }
    close()
}
