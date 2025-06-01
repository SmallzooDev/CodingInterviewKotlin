package problems.baekjoon.p10814

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val lines = mutableListOf<Triple<Int, String, Int>>()
    repeat(n) { index ->
        val (age, name) = readLine()!!.split(" ")
        lines.add(Triple(age.toInt(), name, index))
    }

    lines.sortWith(compareBy<Triple<Int, String, Int>> { it.first }.thenBy { it.third })

    lines.forEach { println("${it.first} ${it.second}") }
    close()
}
