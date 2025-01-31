package problems.leetcode.numberOfIslands

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
}
