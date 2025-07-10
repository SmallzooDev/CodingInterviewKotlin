package problems.baekjoon.p1918

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val res = mutableListOf<Char>()
    val input = readLine()!!.toCharArray()
    val stack = ArrayDeque<Char>()

    for (c in input) {
        if (c.isLetter()) {
            res.add(c)
            continue
        }

        if (c.isClose()) {
            while (!stack.last().isOpen()) {
                val popped = stack.removeLast()
                res.add(popped)
            }
            stack.removeLast()
            continue
        }

        if (c.isOpen()) {
            stack.addLast(c)
            continue
        }

        while (stack.lastOrNull() != null &&
            !stack.last().isOpen() &&
            stack.last().getPriority() >= c.getPriority()) {
            res.add(stack.removeLast())
        }
        stack.addLast(c)
    }

    while (!stack.isEmpty()) {
        res.add(stack.removeLast())
    }

    println(res.joinToString(""))
    close()
}

fun Char.isOpen(): Boolean = this == '('
fun Char.isClose(): Boolean = this == ')'

fun Char.getPriority(): Int {
    return when (this) {
        '(' -> 0
        '+', '-' -> 1
        '*', '/' -> 2
        else -> throw Exception()
    }
}