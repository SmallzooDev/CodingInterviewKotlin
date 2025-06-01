package problems.baekjoon.p2751

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val nums = mutableListOf<Int>()
    repeat(n) {
        nums.add(readLine()!!.toInt())
    }
    nums.sort()

    println(nums.joinToString("\n"))
    close()
}
