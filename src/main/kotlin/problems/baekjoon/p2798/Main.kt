package problems.baekjoon.p2798

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() }
    var maxSum = 0

    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum <= m) {
                    maxSum = maxOf(maxSum, sum)
                }
            }
        }
    }

    println(maxSum)
    close()
}
