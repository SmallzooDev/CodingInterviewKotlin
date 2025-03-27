package problems.leetcode.summaryRanges

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

        if (nums.isEmpty()) return result

        var start = nums[0]

        for (i in 1..nums.size) {
            if (i == nums.size || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add("${start}")
                } else {
                    result.add("${start}->${nums[i - 1]}")
                }

                if (i < nums.size) {
                    start = nums[i]
                }
            }
        }

        return result
    }
}
