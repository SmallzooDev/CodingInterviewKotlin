package problems.baekjoon.p11723

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var set = 0
    repeat(n) {
        val input = readLine()!!.split(" ")
        val command = input[0]

        when (command) {
            "add" -> {
                val num = input[1].toInt()
                set = set or (1 shl num)
            }

            "remove" -> {
                val num = input[1].toInt()
                set = set and (1 shl num).inv()
            }

            "check" -> {
                val num = input[1].toInt()
                println(if (set and (1 shl num) != 0) "1" else "0")
            }

            "toggle" -> {
                val num = input[1].toInt()
                set = set xor (1 shl num)
            }

            "all" -> {
                set = (1 shl 21) - 2
            }

            "empty" -> {
                set = 0
            }
        }

    }
    close()
}