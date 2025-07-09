package problems.baekjoon.p30214

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (s, e) = readLine()!!.split(' ').map { it.toFloat() }
    println(
        if ((s / e) >= 0.5) 'E' else 'H'
    )
    close()
}
