package problems.leetcode.numberOfIslands

import java.util.LinkedList
import java.util.Queue

class Solution {
    val dy = intArrayOf(1, 0, -1, 0)
    val dx = intArrayOf(0, 1, 0, -1)

    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) { 0 } }
        var islandCount = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, visited, i, j)
                    islandCount++
                }
            }
        }
        return islandCount
    }

    private fun dfs(grid: Array<CharArray>, visited: Array<IntArray>, y: Int, x: Int) {
        if (y !in grid.indices || x !in grid[0].indices || visited[y][x] == 1 || grid[y][x] == '0') {
            return
        }

        visited[y][x] = 1

        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            dfs(grid, visited, ny, nx)
        }
    }

    private fun bfs(grid: Array<CharArray>, visited: Array<IntArray>, startY: Int, startX: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(startY, startX))
        visited[startY][startX] = 1

        while (queue.isNotEmpty()) {
            val (y, x) = queue.poll()
            for (i in 0 until 4) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny in grid.indices && nx in grid[0].indices && grid[ny][nx] == '1' && visited[ny][nx] == 0) {
                    visited[ny][nx] = 1
                    queue.add(Pair(ny, nx))
                    queue.add(Pair(ny, nx))
                }
            }
        }
    }
}
