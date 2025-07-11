package problems.baekjoon.p20437

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        val word = readLine()!!
        val k = readLine()!!.toInt()

        val charCount = word.groupBy { it }.mapValues { it.value.size }
        val validChars = charCount.filter { it.value >= k }.keys

        if (validChars.isEmpty()) {
            println(-1)
        } else {
            var minLength = Int.MAX_VALUE
            var maxLength = Int.MIN_VALUE

            for (char in validChars) {
                val positions = mutableListOf<Int>()

                for (i in word.indices) {
                    if (word[i] == char) {
                        positions.add(i)
                    }
                }

                for (i in 0..positions.size - k) {
                    val start = positions[i]
                    val end = positions[i + k - 1]
                    val length = end - start + 1

                    minLength = minOf(minLength, length)
                    maxLength = maxOf(maxLength, length)
                }
            }

            println("$minLength $maxLength")
        }
    }
    close()
}
