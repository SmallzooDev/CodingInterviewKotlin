package problems.baekjoon.p2520

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val ingBase = listOf(8, 8, 4, 1, 9)
    val ingTop = listOf(1, 30, 25, 10)

    repeat(n) {
        readLine()
        val base = readLine()!!.split(' ').map { it.toInt() }
        val top = readLine()!!.split(' ').map { it.toInt() }

        val baseMax = (16 * base.zip(ingBase) { b, ing -> b.toDouble() / ing }.minOrNull()!!).toInt()
        val topSum = top.zip(ingTop) { t, ing -> t / ing }.sum()

        println(min(baseMax, topSum))
    }
}
