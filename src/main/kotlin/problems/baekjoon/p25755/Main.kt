package problems.baekjoon.p25755

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val firstLine = readLine()!!.split(" ")
    val direction = firstLine[0][0]
    val n = firstLine[1].toInt()

    val matrix = mutableListOf<List<Char>>()
    repeat(n) {
        val tmp = readLine().split(" ").map { it[0] }.toList()
        matrix.add(tmp)
    }

    val res = when (direction) {
        'U', 'D' -> {
            matrix.reversed().map { li ->
                li.map { ch -> ch.flip() }
            }
        }
        'L', 'R' -> {
            matrix.map { li ->
                li.reversed().map { ch -> ch.flip() }
            }
        }
        else -> {
            matrix
        }
    }

    res.forEach { row ->
        println(row.joinToString(" "))
    }

    close()
}

fun Char.flip(): Char {
    return when (this) {
       '1', '8' -> this
       '2' -> '5'
       '5', -> '2'
       else -> '?'
    }
}
