package problems.baekjoon.p2503

import java.io.BufferedReader
import java.io.InputStreamReader

data class Input(
    val question: String,
    val strike: Int,
    val ball: Int,
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val inputs = List(n) {
        val (question, strike, ball) = readLine()!!.split(" ")
        Input(question, strike.toInt(), ball.toInt())
    }

    val count = (123..987)
        .map { it.toString() }
        .filter { candidate ->
            !candidate.contains('0') &&
                    candidate.toSet().size == 3
        }
        .count { candidate ->
            inputs.all { input ->
                isValid(candidate, input)
            }
        }

    print(count)
    close()
}

fun isValid(candidate: String, input: Input): Boolean {
    val (strikes, balls) = candidate.indices.fold(Pair(0, 0)) { (s, b), i ->
        when {
            candidate[i] == input.question[i] -> Pair(s + 1, b)
            input.question.contains(candidate[i]) -> Pair(s, b + 1)
            else -> Pair(s, b)
        }
    }

    return strikes == input.strike && balls == input.ball
}

fun wasValid(candidate: String, question: String, strike: Int, ball: Int): Boolean {
    var s = 0
    var b = 0
    for (i in candidate.indices) {
        for (j in question.indices) {
            if (candidate[i] == question[j]) {
                if (i == j) s++
                else b++
            }
        }
    }
    return s == strike && b == ball
}