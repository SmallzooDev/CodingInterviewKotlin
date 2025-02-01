package problems.leetcode.reconstructItinerary

import java.util.PriorityQueue

class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val pathMap = mutableMapOf<String, PriorityQueue<String>>()
        val result = mutableListOf<String>()

        tickets.forEach {
            pathMap.computeIfAbsent(it[0]) { PriorityQueue<String>() }.add(it[1])
        }

        fun dfs(from: String) {
            val moveTo = pathMap[from] ?: PriorityQueue()
            while (!moveTo.isEmpty()) {
                dfs(moveTo.poll())
            }
            result.add(0, from)
        }

        dfs("JFK")
        return result
    }
}


fun main() {
    println(
        Solution().findItinerary(
            listOf(
                listOf("MUC", "LHR"),
                listOf("JFK", "MUC"),
                listOf("SFO", "SJC"),
                listOf("LHR", "SFO")
            )
        )
    )
}