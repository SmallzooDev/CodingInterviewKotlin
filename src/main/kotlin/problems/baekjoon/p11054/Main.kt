package problems.baekjoon.p11054

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val numbers: List<Int> = readLine()!!
        .split(" ")
        .map { it.toInt() }
        .toList()

    val n = numbers.size
    val dpPlus = IntArray(n) { 1 }
    val dpMinus = IntArray(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (numbers[i] > numbers[j]) {
                dpPlus[i] = maxOf(dpPlus[i], dpPlus[j] + 1)
            }
        }
    }

    for (i in n - 2 downTo 0) {
        for (j in n - 1 downTo i + 1) {
            if (numbers[i] > numbers[j]) {
                dpMinus[i] = maxOf(dpMinus[i], dpMinus[j] + 1)
            }
        }
    }

    var result = 0
    for (i in 0 until n) {
        result = maxOf(result, dpPlus[i] + dpMinus[i] - 1)
    }

    println(result)
    close()
}
