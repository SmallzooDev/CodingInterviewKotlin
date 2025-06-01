package problems.baekjoon.p1259

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break
        println(if (n.isPalindrome()) "yes" else "no")
    }
    close()
}

private fun Int.isPalindrome(): Boolean {
    if (this < 10) return true
    if (this % 10 == 0) return false

    var num = this
    var reverse = 0

    while (num > reverse) {
        reverse = reverse * 10 + num % 10
        num /= 10
    }

    return num == reverse || num == reverse / 10
}
