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
            // 현재 문자를 사용했으므로 등장 횟수 감소
            letterCountMap[char] = letterCountMap[char]!! - 1

            // 이미 스택에 있는 문자는 스킵 (중복을 허용하지 않음)
            if (inStack.contains(char)) continue

            // 스택의 마지막 문자가 현재 문자보다 사전순으로 뒤에 있고,
            // 뒤에 다시 나올 수 있다면 해당 문자를 스택에서 제거
            while (stack.isNotEmpty() && stack.last() > char && letterCountMap[stack.last()]!! > 0) {
                inStack.remove(stack.removeLast())
            }

            stack.add(char)
            inStack.add(char)
        }

        // 스택에 저장된 결과를 문자열로 변환하여 반환
        return stack.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    println(solution.removeDuplicateLetters("bcabc"))
}
