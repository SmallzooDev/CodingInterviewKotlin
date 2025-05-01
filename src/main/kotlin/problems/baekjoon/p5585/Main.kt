package problems.baekjoon.p5585

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var change = 1000 - readLine().toInt()
    val coins = listOf(500, 100, 50, 10, 5, 1)
    var result = 0;
    coins.forEach {
        val cnt = change / it
        result += cnt
        change %= it
    }
    println(result)
    close()
}
