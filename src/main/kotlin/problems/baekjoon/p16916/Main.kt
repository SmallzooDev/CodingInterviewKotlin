package problems.baekjoon.p16916

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val whole = readLine()!!
    val part = readLine()!!

    var found = false
    for (i in 0..whole.length - part.length) {
        if (whole.substring(i, i + part.length) == part) {
            found = true
            break
        }
    }
    println(if (found) 1 else 0)
    close()
}