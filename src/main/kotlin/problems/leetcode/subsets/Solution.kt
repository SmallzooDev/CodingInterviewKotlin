package problems.leetcode.subsets

import java.util.ArrayList

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(current: MutableList<Int>, start: Int) {
            println("현재 부분 집합: $current, start: $start until: ${nums.size - 1}")
            result.add(ArrayList(current))

            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack(current, i + 1)
                current.removeLast()
            }
        }

        backtrack(mutableListOf(), 0)
        return result
    }
}

fun main() {
    println(Solution().subsets(intArrayOf(1, 2, 3, 4, 5)))
}
