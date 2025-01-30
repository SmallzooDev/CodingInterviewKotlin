package problems.leetcode.validParentheses

class Solution {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        val matchingPairs = mapOf(')' to '(', '}' to '{', ']' to '[')

        for (char in s) {
            if (char in matchingPairs.values) {
                stack.add(char)
            } else {
                if (stack.isEmpty() || stack.removeLast() != matchingPairs[char]) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}
