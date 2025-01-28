package problems.leetcode.longestPalindromicSubstring


class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var start = 0
        var maxLen = 0

        fun expandAroundCenter(left: Int, right: Int): Pair<Int, Int> {
            var l = left
            var r = right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
            }
            return Pair(l + 1, r - 1)
        }

        for (i in s.indices) {
            val (start1, end1) = expandAroundCenter(i, i)
            val (start2, end2) = expandAroundCenter(i, i + 1)

            // 홀수 팰린드롬 길이 비교
            if (end1 - start1 + 1 > maxLen) {
                start = start1
                maxLen = end1 - start1 + 1
            }

            // 짝수 팰린드롬 길이 비교
            if (end2 - start2 + 1 > maxLen) {
                start = start2
                maxLen = end2 - start2 + 1
            }
        }

        return s.substring(start, start + maxLen)
    }
}
