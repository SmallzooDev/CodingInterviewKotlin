package problems.baekjoon.p9328

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val movable = listOf(
        1 to 0,
        0 to 1,
        -1 to 0,
        0 to -1,
    )

    repeat(n) {
        val (my, mx) = readLine()!!.split(' ').map { it.toInt() }
        val graph = mutableListOf<CharArray>()
        repeat(my) {
            graph.add(
                readLine()!!.toCharArray()
            )
        }
        val keys = readLine()!!

        var currentKeys = 0
        if (keys != "0") {
            for (key in keys) {
                currentKeys = currentKeys or (1 shl (key - 'a'))
            }
        }

        val documents = mutableSetOf<Pair<Int, Int>>()
        var res = 0

        var prevKeys = -1
        while (prevKeys != currentKeys) {
            prevKeys = currentKeys

            val visited = Array(my) { BooleanArray(mx) }
            val queue = LinkedList<Pair<Int, Int>>()

            for (i in 0 until my) {
                for (j in 0 until mx) {
                    if ((i == 0 || i == my - 1 || j == 0 || j == mx - 1) && graph[i][j] != '*') {
                        if (canPass(graph[i][j], currentKeys) && !visited[i][j]) {
                            visited[i][j] = true
                            queue.offer(i to j)

                            if (graph[i][j] == '$' && !documents.contains(i to j)) {
                                res++
                                documents.add(i to j)
                            }

                            if (graph[i][j] in 'a'..'z') {
                                currentKeys = currentKeys or (1 shl (graph[i][j] - 'a'))
                            }
                        }
                    }
                }
            }

            // BFS로 탐색
            while (queue.isNotEmpty()) {
                val (y, x) = queue.poll()

                for ((dy, dx) in movable) {
                    val ny = y + dy
                    val nx = x + dx

                    if (ny in 0 until my && nx in 0 until mx && graph[ny][nx] != '*') {
                        if (canPass(graph[ny][nx], currentKeys) && !visited[ny][nx]) {
                            visited[ny][nx] = true
                            queue.offer(ny to nx)

                            if (graph[ny][nx] == '$' && !documents.contains(ny to nx)) {
                                res++
                                documents.add(ny to nx)
                            }

                            if (graph[ny][nx] in 'a'..'z') {
                                currentKeys = currentKeys or (1 shl (graph[ny][nx] - 'a'))
                            }
                        }
                    }
                }
            }
        }

        println(res)
    }
    close()
}

fun canPass(cell: Char, keys: Int): Boolean {
    return when (cell) {
        '.', '$' -> true
        in 'a'..'z' -> true
        in 'A'..'Z' -> (keys and (1 shl (cell - 'A'))) != 0
        else -> false
    }
}