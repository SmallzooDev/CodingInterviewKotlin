package problems.baekjoon.p1181

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cnt = readLine()!!.toInt()
    val strs = mutableSetOf<String>()

    repeat(cnt) {
        strs.add(readLine()!!)
    }

    strs.sortedWith(compareBy<String> { it.length }.thenBy { it })
        .forEach { println(it) }

    close()
}
