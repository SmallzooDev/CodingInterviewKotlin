package problems.baekjoon.p2609

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    println(gcd(a, b))
    println(lcm(a, b))
    close()
}

fun gcd(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        val temp = b
        b = a % b
        a = temp
    }
    return a
}

fun lcm(a: Int, b: Int): Int {
    return if (a == 0 || b == 0) 0 else a * b / gcd(a, b)
}