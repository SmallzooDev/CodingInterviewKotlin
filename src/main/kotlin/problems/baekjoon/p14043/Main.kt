package problems.baekjoon.p14043

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val first = readLine()!!
    val second = readLine()!!

    val charCount = first.groupingBy { it }.eachCount().toMutableMap()
    var wildcards = 0

    for (char in second) {
        when (char) {
            '*' -> wildcards++
            else -> {
                val available = charCount[char] ?: 0
                if (available <= 0) {
                    println('N')
                    close()
                    return
                }
                charCount[char] = available - 1
            }
        }
    }

    println(if (charCount.values.sum() <= wildcards) 'A' else 'N')
    close()
}