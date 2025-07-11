package problems.baekjoon.p16171

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    if (readLine()!!
            .toCharArray()
            .filter { !it.isDigit() }
            .joinToString("")
            .contains(readLine()!!)
        ) {
        println('1')
    } else {
        println('0')
    }
    close()
}
