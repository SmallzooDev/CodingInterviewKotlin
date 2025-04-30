package problems.baekjoon.p1182

import java.io.BufferedReader
import java.io.InputStreamReader

fun combination(
    nums: List<Int>,
    selected: MutableList<Int>,
    idx: Int,
    level: Int,
    target: Int,
    counter: (Boolean) -> Unit
) {
    if (selected.size == level) {
        if (selected.sum() == target) {
            counter(true)
        }
        return
    }

    for (i in idx until nums.size) {
        selected.add(nums[i])
        combination(nums, selected, i + 1, level, target, counter)
        selected.removeAt(selected.lastIndex)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, target) = readLine().split(" ").map { it.toInt() }
    val nums = readLine().split(" ").map { it.toInt() }

    var count = 0

    for (level in 1..n) {
        val selected = mutableListOf<Int>()
        combination(nums, selected, 0, level, target) { matched ->
            if (matched) count++
        }
    }

    println(count)
    close()
}
