package problems.baekjoon.p4153

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    generateSequence {
        readlnOrNull()?.split(" ")?.map(String::toInt)?.let { Triple(it[0], it[1], it[2]) }
    }
        .takeWhile { (a, b, c) -> a != 0 || b != 0 || c != 0 }
        .forEach { triangle ->
            println(if (triangle.isRightTriangle()) "right" else "wrong")
        }
}

private fun Triple<Int, Int, Int>.isRightTriangle(): Boolean {
    val (a, b, c) = this
    val squares = listOf(a * a, b * b, c * c).sorted()
    return squares[0] + squares[1] == squares[2]
}
