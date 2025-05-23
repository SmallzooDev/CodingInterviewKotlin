package org.example.problems.programmers.reportuser

class Solution {
    fun solution(idList: Array<String>, report: Array<String>, k: Int): IntArray {
        val userIndex = idList.withIndex().associate { it.value to it.index }
        val reportMap = mutableMapOf<String, MutableSet<String>>()

        report.map { it.split(" ") }
            .forEach { (reporter, reported) ->
                reportMap.computeIfAbsent(reported) { mutableSetOf() }.add(reporter)
            }

        val answer = IntArray(idList.size)

        reportMap.filter { it.value.size >= k }
            .flatMap { it.value }
            .forEach { reporter -> answer[userIndex[reporter]!!]++ }

        return answer
    }
}