package problems.baekjoon.p1342

import java.io.BufferedReader
import java.io.InputStreamReader

data class MemoKey(
    val tmpLen: Int,
    val lastCharIdx: Int?,
    val counts: List<Int>,
)

fun getHappyNumCount(
    len: Int,
    tmpLen: Int,
    lastCharIdx: Int?,
    counts: MutableList<Int>,
    memo: MutableMap<MemoKey, Int>
): Int {
    if (tmpLen == len) return 1

    val key = MemoKey(tmpLen, lastCharIdx, counts.toList())

    memo[key]?.let { return it }

    var result = 0
    for (i in 0 until 26) {
        if (counts[i] > 0 && lastCharIdx != i) {
            counts[i] -= 1
            result += getHappyNumCount(len, tmpLen + 1, i, counts, memo)
            counts[i] += 1
        }
    }

    memo[key] = result
    return result
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()!!
    val counts = MutableList(26) { 0 }
    for (c in input) counts[c - 'a'] += 1

    println(getHappyNumCount(input.length, 0, null, counts, mutableMapOf()))
    close()
}
