package problems.baekjoon.p32141

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (_, h) = readLine()!!.split(' ').map { it.toInt() }
    val cards = readLine()!!.split(' ').map { it.toInt() }.toMutableList()

    var count = 0
    while (count < cards.size) {
        if (h <= 0) {
            break
        }

        h -= cards[count]
        count += 1
    }

    if (h > 0) {
        println(-1)
    } else {
        println(count)
    }

    close()
}
