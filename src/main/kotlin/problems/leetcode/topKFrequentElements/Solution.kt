package problems.leetcode.topKFrequentElements

import java.util.PriorityQueue

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var frequentMap = mutableMapOf<Int, Int>()
        nums.forEach {
            frequentMap[it] = frequentMap.getOrPut(it) { 0 } + 1
        }
        return frequentMap.entries
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }
            .toIntArray()
    }

    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        val frequentMap = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            frequentMap[num] = frequentMap.getOrDefault(num, 0) + 1
        }

        val minHeap = PriorityQueue<Map.Entry<Int, Int>>(compareBy { it.value })

        for (entry in frequentMap.entries) {
            minHeap.add(entry)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        return minHeap.map { it.key }.toIntArray()
    }
}
