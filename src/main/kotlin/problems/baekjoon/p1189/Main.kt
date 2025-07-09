package problems.baekjoon.p1189

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

val moves = listOf(
    1 to 0,
    0 to 1,
    -1 to 0,
    0 to -1
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (r, c, k) = readLine()!!.split(' ').map { it.toInt() }
    val graph = mutableListOf<CharArray>()

    repeat(r) {
        graph.add(readLine()!!.toCharArray())
    }

    val visited = Array(r) { BooleanArray(c) }

    visited[r-1][0] = true

    val res = dfs(
        graph,
        visited,
        r - 1,
        0,
        0,
        c - 1,
        1,
        k
    )

    println(res)
    close()
}

fun dfs(
    graph: MutableList<CharArray>,
    visited: Array<BooleanArray>,
    x: Int,
    y: Int,
    targetX: Int,
    targetY: Int,
    distance: Int,
    k: Int
): Int {
    if (x == targetX && y == targetY && distance == k) {
        return 1
    }

    if (distance >= k) {
        return 0
    }

    val minDist = abs(x - targetX) + abs(y - targetY)
    if (distance + minDist > k) {
        return 0
    }

    val remaining = k - distance
    if ((remaining - minDist) % 2 != 0) {
        return 0
    }

    var count = 0

    for ((dx, dy) in moves) {
        val nx = x + dx
        val ny = y + dy

        if (nx < 0 || ny < 0 || nx >= graph.size || ny >= graph[0].size ||
            graph[nx][ny] == 'T' || visited[nx][ny]) {
            continue
        }

        visited[nx][ny] = true
        count += dfs(graph, visited, nx, ny, targetX, targetY, distance + 1, k)
        visited[nx][ny] = false
    }

    return count
}
