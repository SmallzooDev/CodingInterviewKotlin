package problems.baekjoon.p1912

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val inputs = readLine()!!.split(" ").map { it.toInt() }

    var maxEndingHere = inputs[0];
    var maxSoFar = inputs[0];

    for (i in 0 until inputs.size) {
        maxEndingHere = max(inputs[i], maxEndingHere + inputs[i])
        maxSoFar = max(maxEndingHere, maxSoFar)
    }

    println(maxSoFar)
    close()
}
