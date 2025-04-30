package problems.baekjoon.p11650

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }
    list.sortWith(compareBy({it.first}, { it.second}))
    for ((a, b) in list) {
        println("$a $b")
    }
    close()
}
