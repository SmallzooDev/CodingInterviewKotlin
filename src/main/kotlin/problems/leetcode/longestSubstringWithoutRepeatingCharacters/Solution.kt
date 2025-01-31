package problems.leetcode.longestSubstringWithoutRepeatingCharacters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val occurSet = mutableSetOf<Char>()
        var left = 0
        var maxLen = 0

        for (right in s.indices) {
            while (s[right] in occurSet) {
                occurSet.remove(s[left])
                left++
            }
            occurSet.add(s[right])
            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }
}
