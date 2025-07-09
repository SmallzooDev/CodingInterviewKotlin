package problems.baekjoon.p3986

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val count = (1..n).count {
        readLine()!!.isNiceString()
    }
    println(count)
    close()
}

private fun String.isNiceString(): Boolean =
    fold(ArrayDeque<Char>()) { stack, char ->
        when {
            stack.isEmpty() || stack.last() != char -> stack.apply { addLast(char) }
            else -> stack.apply { removeLast() }
        }
    }.isEmpty()