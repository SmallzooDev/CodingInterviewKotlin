package problems.leetcode.letterCombinationsOfAPhoneNumber

class Solution {
    private val numberMap = mapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z')
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val result: MutableList<String> = mutableListOf()
        dfs(0, StringBuilder(), digits, result)
        return result
    }

    private fun dfs(idx: Int, path: StringBuilder, digits: String, result: MutableList<String>) {
        if (path.length == digits.length) {
            result.add(path.toString())
            return
        }

        for (c in numberMap[digits[idx]] ?: emptyList()) {
            path.append(c)
            dfs(idx + 1, path, digits, result)
            path.deleteCharAt(path.length - 1)
        }
    }
}