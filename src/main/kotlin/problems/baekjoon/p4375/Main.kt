package problems.baekjoon.p4375

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val line = readLine() ?: break
        val n = line.toInt()
        println(findOnesMultiple(n))
    }
    close()
}

fun findOnesMultiple(target: Int): Int {
    var digit = 1;
    var current = 1L;
    while (true) {
        if (current % target == 0L) {
            return digit
        }
        current = (current * 10 + 1) % target
        digit++
    }
}