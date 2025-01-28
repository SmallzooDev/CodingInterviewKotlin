package org.example.problems.leetcode.validPalindrome

class Solution {
    // 500ms
    fun isPalindrome(s: String): Boolean {
        val letters = s.lowercase().filter { it.isLetterOrDigit() }
        return letters == letters.reversed()
    }

    // 4ms
    fun isPalindrome2(s: String): Boolean {
        var start = 0
        var end = s.length - 1
        while (start < end) {
            when {
                !Character.isLetterOrDigit(s[start]) -> start++
                !Character.isLetterOrDigit(s[end]) -> end--
                else -> {
                    if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                        return false;
                    }
                    start++
                    end--
                }
            }
        }
        return true
    }
}