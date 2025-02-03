package problems.leetcode.networkDelayTime

import java.util.PriorityQueue

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        for (time in times) {
            val (u, v, w) = time
            graph[u].add(Pair(v, w))
        }

        val distances = IntArray(n + 1) { Int.MAX_VALUE }
        distances[k] = 0

        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        priorityQueue.add(Pair(0, k))

        while (priorityQueue.isNotEmpty()) {
            val (currentDistance, currentNode) = priorityQueue.poll()

            if (currentDistance > distances[currentNode]) continue

            for ((neighbor, weight) in graph[currentNode]) {
                val newDistance = currentDistance + weight
                if (newDistance < distances[neighbor]) {
                    distances[neighbor] = newDistance
                    priorityQueue.add(Pair(newDistance, neighbor))
                }
            }
        }

        val maxDistance = distances.filterIndexed { index, _ -> index != 0 }.maxOrNull() ?: Int.MAX_VALUE

        return if (maxDistance == Int.MAX_VALUE) -1 else maxDistance
    }
}
