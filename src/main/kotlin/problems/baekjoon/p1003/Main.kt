package problems.baekjoon.p1003

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()

    val zeroCount = IntArray(41)
    val oneCount = IntArray(41)

    zeroCount[0] = 1
    zeroCount[1] = 0
    oneCount[0] = 0
    oneCount[1] = 1

    for (i in 2..40) {
        zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2]
        oneCount[i] = oneCount[i - 1] + oneCount[i - 2]
    }

    repeat(t) {
        val n = readLine()!!.toInt()
        println("${zeroCount[n]} ${oneCount[n]}")
    }

    close()
}
