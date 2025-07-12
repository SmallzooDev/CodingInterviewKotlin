package problems.baekjoon.p17413

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var input = readLine()!!
    var i = 0

    while (i < input.length) {
        when {
            input[i] == '<' -> {
                i = input.indexOf('>', i) + 1
            }
            input[i] == ' ' -> {
                i++
            }
            else -> {
                val start = i
                while (i < input.length && input[i] != '<' && input[i] != ' ') {
                    i++
                }
                val end = i - 1

                if (start <= end) {
                    input = input.reverseRange(start, end)
                }
            }
        }
    }

    println(input)
    close()
}

fun String.reverseRange(start: Int, end: Int): String {
    val arr = this.toCharArray()
    var left = start
    var right = end
    while (left < right) {
        val tmp = arr[right]
        arr[right] = arr[left]
        arr[left] = tmp
        left++
        right--
    }
    return String(arr)
}