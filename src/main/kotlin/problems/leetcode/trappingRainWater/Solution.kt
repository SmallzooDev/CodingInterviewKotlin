package problems.leetcode.trappingRainWater

class Solution {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var leftPointer = 0
        var rightPointer = height.lastIndex
        var leftMax = 0
        var rightMax = 0

        return generateSequence {
            if (leftPointer < rightPointer) {
                if (height[leftPointer] < height[rightPointer]) {
                    val trapped = (leftMax - height[leftPointer]).coerceAtLeast(0)
                    leftMax = maxOf(leftMax, height[leftPointer])
                    leftPointer++
                    trapped
                } else {
                    val trapped = (rightMax - height[rightPointer]).coerceAtLeast(0)
                    rightMax = maxOf(rightMax, height[rightPointer])
                    rightPointer--
                    trapped
                }
            } else {
                null
            }
        }.sum()
    }
}
