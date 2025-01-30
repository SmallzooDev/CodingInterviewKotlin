package problems.leetcode.removeDuplicateLetters

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val letterCountMap = mutableMapOf<Char, Int>()
        val stack = mutableListOf<Char>()
        val inStack = mutableSetOf<Char>()

        s.forEach {
            letterCountMap[it] = letterCountMap.getOrPut(it) { 0 } + 1
        }

        for (char in s) {
            letterCountMap[char] = letterCountMap[char]!! - 1
            if (inStack.contains(char)) continue
            while (stack.isNotEmpty() && stack.last() > char && letterCountMap[stack.last()]!! > 0) {
                inStack.remove(stack.removeLast())
            }

            stack.add(char)
            inStack.add(char)
        }

        return stack.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    println(solution.removeDuplicateLetters("bcabc"))
}
