package problems.leetcode.twoSum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairMap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (pairMap.containsKey(complement)) {
                return intArrayOf(pairMap[complement]!!, i)
            }
            pairMap[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum")
    }
}
