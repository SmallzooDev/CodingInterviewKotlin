package problems.baekjoon.p4779

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun generateCantor(builder: StringBuilder, start: Int, end: Int) {
    if (end - start < 3) return

    val third = (end - start) / 3
    val midStart = start + third
    val midEnd = start + 2 * third

    for (i in midStart until midEnd) {
        builder.setCharAt(i, ' ')
    }

    generateCantor(builder, start, midStart)
    generateCantor(builder, midEnd, end)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numbers = mutableListOf<Int>()
    var line: String?

    while (readLine().also { line = it } != null) {
        if (line.isNullOrEmpty()) break
        numbers.add(line!!.toInt())
    }

    for (n in numbers) {
        val length = 3.0.pow(n.toDouble()).toInt()
        val builder = StringBuilder("-".repeat(length))
        generateCantor(builder, 0, length)
        println(builder.toString())
    }

    close()
}