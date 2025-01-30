package problems.leetcode.dailyTemperatures

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        var stack = mutableListOf<Pair<Int, Int>>()
        var result = MutableList(temperatures.size) { 0 }
        for ((idx, temperature) in temperatures.withIndex()) {
            if (stack.isEmpty()) {
                stack.add(Pair(idx, temperature))
                continue
            }

            if (stack.last().second < temperature) {
                while (!stack.isEmpty() && stack.last().second < temperature) {
                    val poppedPair = stack.removeLast()
                    result[poppedPair.first] = idx - poppedPair.first
                }
            }

            stack.add(Pair(idx, temperature))
        }

        return result.toIntArray()
    }

    fun dailyTemperatures2(temperatures: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        val result = IntArray(temperatures.size)

        for ((idx, temperature) in temperatures.withIndex()) {
            while (stack.isNotEmpty() && temperatures[stack.last()] < temperature) {
                val lastIndex = stack.removeLast()
                result[lastIndex] = idx - lastIndex
            }

            stack.add(idx)
        }

        return result
    }
}
