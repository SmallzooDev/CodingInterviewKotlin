package problems.baekjoon.p1316

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val groupWordCount = (1..n).count {
        readLine()!!.isGroupWord()
    }
    println(groupWordCount)
    close()
}

fun String.isGroupWord(): Boolean {
    val used = mutableSetOf<Char>()
    var prev = this[0]

    for (current in this) {
        if (current != prev) {
            if (current in used) {
                return false
            }
            used.add(prev)
        }
        prev = current
    }
    return true
}