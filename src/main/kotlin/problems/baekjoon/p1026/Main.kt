package problems.baekjoon.p1026

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val aVals = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val bVals = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    println(aVals.zip(bVals).sumOf { (a, b) -> a * b })
    close()
}
