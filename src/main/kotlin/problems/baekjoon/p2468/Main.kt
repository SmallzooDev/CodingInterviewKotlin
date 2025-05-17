package problems.baekjoon.p2468

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val maxLength = readLine()!!.toInt()
    val graph = List(maxLength) {
        readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    }
    val maxHeight = graph.maxOf { it.maxOrNull() ?: 0 }

    val output = (0 until maxHeight).maxOf { k ->
        val tmp = rainDrop(graph, k)
        var count = 0

        for (i in 0 until maxLength) {
            for (j in 0 until maxLength) {
                if (tmp[i][j] == 1) {
                    count++
                    dfs(tmp, i, j)
                }
            }
        }
        count
    }.coerceAtLeast(1)

    println("$output")
    close()
}

fun rainDrop(graph: List<MutableList<Int>>, target: Int): MutableList<MutableList<Int>> {
    return graph.map { line ->
        line.map { if (it > target) 1 else 0 }.toMutableList()
    }.toMutableList()
}

fun dfs(visited: MutableList<MutableList<Int>>, y: Int, x: Int) {
    val directions = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
    visited[y][x] = 0

    directions.forEach { (dy, dx) ->
        val ny = y + dy
        val nx = x + dx
        if (ny in visited.indices && nx in visited[0].indices && visited[ny][nx] == 1) {
            dfs(visited, ny, nx)
        }
    }
}
