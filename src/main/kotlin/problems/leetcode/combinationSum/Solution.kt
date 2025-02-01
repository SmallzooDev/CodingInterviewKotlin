package problems.leetcode.combinationSum

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(current: MutableList<Int>, target: Int, start: Int) {
            if (target == 0) {
                result.add(ArrayList(current))
                return
            }

            for (i in start until candidates.size) {
                if (target < candidates[i]) continue
                current.add(candidates[i])
                backtrack(current, target - candidates[i], i)
                current.removeLast()
            }
        }

        backtrack(mutableListOf(), target, 0)
        return result
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(current: MutableList<Int>, target: Int, start: Int) {
            println("현재 조합: $current, 남은 타겟: $target")

            if (target == 0) {
                println("조합 완성: $current")
                result.add(ArrayList(current))
                return
            }

            for (i in start until candidates.size) {
                if (target < candidates[i]) {
                    println("타겟 초과: ${candidates[i]} (현재 남은 타겟: $target)")
                    continue
                }

                println("숫자 추가: ${candidates[i]} (현재 조합: $current)")
                current.add(candidates[i])

                backtrack(current, target - candidates[i], i)

                println("백트래킹: ${current.removeLast()} 제거 후 현재 조합: $current")
            }
        }

        backtrack(mutableListOf(), target, 0)
        return result
    }
}

fun main() {
    println(Solution().combinationSum2(intArrayOf(2, 3, 5), 8))
}
