package problems.leetcode.arrayPartition

class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        return nums.sorted().foldIndexed(0) { index, acc, num ->
            if (index % 2 == 0) acc + num else acc
        }
    }
}

