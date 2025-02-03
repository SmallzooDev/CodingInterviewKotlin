package problems.leetcode.cheapestFlightsWithinKStops

import java.util.PriorityQueue

data class State(var cost: Int, var node: Int, var count: Int)

class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        flights.forEach {
            val (start, arrive, cost) = it
            graph[start].add(Pair(arrive, cost))
        }

        val pq = PriorityQueue<State>(compareBy { it.cost })
        pq.add(State(0, src, 0))

        val minCost = Array(n) { IntArray(k + 2) { Int.MAX_VALUE } }
        minCost[src][0] = 0

        while (pq.isNotEmpty()) {
            val (currentCost, currentNode, stops) = pq.poll()

            if (currentNode == dst) return currentCost

            if (stops > k) continue

            for ((neighbor, weight) in graph[currentNode]) {
                val newCost = currentCost + weight

                if (newCost < minCost[neighbor][stops + 1]) {
                    minCost[neighbor][stops + 1] = newCost
                    pq.add(State(newCost, neighbor, stops + 1))
                }
            }
        }

        return -1
    }
}
