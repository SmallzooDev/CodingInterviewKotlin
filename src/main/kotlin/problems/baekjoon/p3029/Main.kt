package problems.baekjoon.p3029

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val from = readLine()!!.getTime()
    val to = readLine()!!.getTime()

    val diff = when {
        from < to -> to - from
        from > to -> 86400 + to - from
        else -> 86400
    }

    println(diff.toTimeFormat())
    close()
}

fun String.getTime(): Int = this.split(':').mapIndexed { i, num ->
    when (i) {
        0 -> 60 * 60 * num.toInt()
        1 -> 60 * num.toInt()
        2 -> num.toInt()
        else -> 0
    }
}.sum()

fun Int.toTimeFormat(): String {
    val h = this / 3600
    val m = (this % 3600) / 60
    val s = this % 60
    return String.format("%02d:%02d:%02d", h, m, s)
}