package problems.baekjoon.p21983

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toDouble()
    val result = sqrt((n * 2) / (3 * sqrt(3.0))) * 6
    println("%.8f".format(result))
    close()
}
