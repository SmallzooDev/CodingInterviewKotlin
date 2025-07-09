package problems.baekjoon.p3982

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        val winCountMap = mutableMapOf<String, Int>()

        repeat(16) {
            val roundWinner = readLine()!!.getWinner()
            winCountMap[roundWinner] = (winCountMap[roundWinner]?: 0) + 1
        }
        
        val winner = winCountMap.maxByOrNull { it.value }?.key
        println(winner)
    }
    close()
}

fun String.getWinner(): String {
    val match = this.split(' ')
    return if (match[2].toInt() > match[3].toInt()) match[0] else match[1]
}