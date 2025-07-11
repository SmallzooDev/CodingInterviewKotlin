package problems.baekjoon.p11365

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val tmp = readLine()!!
        if (tmp == "END") break else println(tmp.reversed())
    }
    close()
}
