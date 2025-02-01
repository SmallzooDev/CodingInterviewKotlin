package problems.leetcode.permutations

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val used = BooleanArray(nums.size)

        fun backtrack(current: MutableList<Int>) {
            if (current.size == nums.size) {
                result.add(ArrayList(current))
                return
            }

            for (i in nums.indices) {
                if (used[i]) continue

                used[i] = true
                current.add(nums[i])
                backtrack(current)
                current.removeAt(current.size - 1)
                used[i] = false
            }
        }

        backtrack(mutableListOf())
        return result
    }
}


fun main() {
    println(
        Solution().permute(
            intArrayOf(
                9,
                2,
                3
            )
        )
    )
}