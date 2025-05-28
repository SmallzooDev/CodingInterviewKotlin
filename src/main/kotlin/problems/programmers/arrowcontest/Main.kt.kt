package org.example.problems.programmers.arrowcontest

// https://school.programmers.co.kr/learn/courses/30/lessons/92342?language=kotlin
class Solution {
    private var maxDiff = 0
    private var bestAnswer = intArrayOf(-1)

    fun solution(n: Int, info: IntArray): IntArray {
        val ryan = IntArray(11) { 0 }
        dfs(info, ryan, 0, n)
        return bestAnswer
    }

    private fun dfs(apeach: IntArray, ryan: IntArray, idx: Int, remaining: Int) {
        if (idx == 11) {
            ryan[10] = remaining

            val diff = calculateScoreDifference(apeach, ryan)
            if (diff > maxDiff) {
                maxDiff = diff
                bestAnswer = ryan.clone()
            } else if (diff == maxDiff && diff > 0) {
                if (isLowerScorePreferred(ryan, bestAnswer)) {
                    bestAnswer = ryan.clone()
                }
            }

            ryan[10] = 0
            return
        }

        dfs(apeach, ryan, idx + 1, remaining)

        val neededArrows = apeach[idx] + 1
        if (remaining >= neededArrows) {
            ryan[idx] = neededArrows
            dfs(apeach, ryan, idx + 1, remaining - neededArrows)
            ryan[idx] = 0 // backtrack
        }
    }

    private fun calculateScoreDifference(apeach: IntArray, ryan: IntArray): Int {
        var apeachScore = 0
        var ryanScore = 0

        for (i in 0..10) {
            val score = 10 - i
            when {
                ryan[i] > apeach[i] -> ryanScore += score
                apeach[i] > 0 -> apeachScore += score
            }
        }

        return ryanScore - apeachScore
    }

    private fun isLowerScorePreferred(current: IntArray, best: IntArray): Boolean {
        for (i in 10 downTo 0) {
            if (current[i] > best[i]) return true
            if (current[i] < best[i]) return false
        }
        return false
    }
}