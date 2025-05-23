package problems.baekjoon.p2812

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!

    val stack = Stack<Char>()
    var toRemove = k

    for (digit in nums) {
        while (stack.isNotEmpty() && stack.peek() < digit && toRemove > 0) {
            stack.pop()
            toRemove--
        }
        stack.push(digit)
    }

    while (toRemove > 0) {
        stack.pop()
        toRemove--
    }

    val result = StringBuilder()
    for (digit in stack) {
        result.append(digit)
    }

    val output = result.toString().trimStart('0')
    println(output.ifEmpty { "0" })

    close()
}
