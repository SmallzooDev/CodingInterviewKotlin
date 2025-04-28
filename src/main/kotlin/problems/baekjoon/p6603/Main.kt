package problems.baekjoon.p6603

import java.io.BufferedReader
import java.io.InputStreamReader

fun List<Int>.findLottoCombinations(result: MutableList<Int> = mutableListOf(), index: Int = 0) {
    if (result.size == 6) {
        println(result.joinToString(" "))
        return
    }

    if (result.size + (size - index) < 6) return

    for (i in index until size) {
        result.add(this[i])
        findLottoCombinations(result, i + 1)
        result.removeAt(result.lastIndex)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    generateSequence { readLine() }
        .takeWhile { it != "0" }
        .forEach { line ->
            val numbers = line.split(" ").map { it.toInt() }
            numbers.drop(1).findLottoCombinations()
            println()
        }
}
