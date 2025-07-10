package problems.baekjoon.p16928

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (l, s) = readLine()!!.split(' ').map { it.toInt() }
    val board = IntArray(101) { it }

    repeat(l) {
        val (from, to) = readLine()!!.split(' ').map { it.toInt() }
        board[from] = to
    }

    repeat(s) {
        val (from, to) = readLine()!!.split(' ').map { it.toInt() }
        board[from] = to
    }

    val visited = BooleanArray(101)
    val queue = LinkedList<Pair<Int, Int>>()

    queue.offer(Pair(1, 0))
    visited[1] = true

    while (queue.isNotEmpty()) {
        val (current, steps) = queue.poll()

        if (current == 100) {
            println(steps)
            break
        }

        for (dice in 1..6) {
            var next = current + dice
            if (next > 100) continue

            next = board[next]

            if (!visited[next]) {
                visited[next] = true
                queue.offer(Pair(next, steps + 1))
            }
        }
    }

    close()
}