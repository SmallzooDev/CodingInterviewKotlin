package problems.leetcode.mostCommonWord

class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val words = paragraph
            .replace("[^a-zA-Z ]".toRegex(), " ")
            .lowercase()
            .split("\\s+".toRegex())

        val bannedSet = banned.toSet()
        val wordsCountMap = mutableMapOf<String, Int>()

        words.forEach { word ->
            if (word.isNotBlank() && word !in bannedSet) {
                wordsCountMap[word] = wordsCountMap.getOrPut(word) { 0 } + 1
            }
        }

        return wordsCountMap.maxByOrNull { it.value }?.key ?: ""
    }
}
