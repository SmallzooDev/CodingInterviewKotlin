package problems.leetcode.jewelsAndStones

class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelSet = jewels.toSet()
        return stones.count { it in jewelSet }
    }
}
