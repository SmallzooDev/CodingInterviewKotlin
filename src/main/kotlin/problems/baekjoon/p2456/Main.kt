package problems.baekjoon.p2456

import java.io.BufferedReader
import java.io.InputStreamReader

data class Candidate(var first: Int = 0, var second: Int = 0, var third: Int = 0) {
    val sum get() = first * 3 + second * 2 + third

    fun addVote(score: Int) {
        when (score) {
            3 -> first++
            2 -> second++
            1 -> third++
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val candidates = Array(3) { Candidate() }

    repeat(n) {
        val votes = readLine()!!.split(' ').map{it.toInt()}
        votes.forEachIndexed { index, score ->
            candidates[index].addVote(score)
        }
    }

    val maxSum = candidates.maxOf { it.sum }
    val winners = candidates.withIndex()
        .filter { it.value.sum == maxSum }
        .sortedWith(compareByDescending<IndexedValue<Candidate>> { it.value.first }
            .thenByDescending { it.value.second }
            .thenBy { it.index })

    val (winnerIndex, winnerSum) = when {
        winners.size == 1 -> winners[0].index + 1 to maxSum
        winners[0].value.first != winners[1].value.first -> winners[0].index + 1 to maxSum
        winners[0].value.second != winners[1].value.second -> winners[0].index + 1 to maxSum
        else -> 0 to maxSum
    }

    println("$winnerIndex $winnerSum")
}