package problems.leetcode.groupAnagrams

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var anagramMap = mutableMapOf<String, MutableList<String>>()
        var result = mutableListOf<MutableList<String>>()

        strs.forEach(fun(word) {
            val anagram = word.toCharArray().sorted().joinToString("")
            anagramMap.getOrPut(anagram) { mutableListOf() }.add(word)
        })

        result.addAll(anagramMap.values)
        return result
    }

    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        return strs.fold(mutableMapOf<String, MutableList<String>>()) { map, word ->
            // 알파벳 정렬된 키 생성
            val key = word.toCharArray().sorted().joinToString("")
            // 키를 기준으로 리스트에 추가
            map.getOrPut(key) { mutableListOf() }.add(word)
            map
        }.values.toList()
    }
}
