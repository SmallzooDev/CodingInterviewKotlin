package problems.baekjoon.p11720

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
     val _n = readLine().toInt()
    println(
        readLine()!!.toCharArray().sumOf { it.digitToInt() }
    )
    close()
}