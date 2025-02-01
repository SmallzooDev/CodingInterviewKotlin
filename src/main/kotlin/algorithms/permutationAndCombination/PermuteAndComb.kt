package org.example.algorithms.permutationAndCombination

class PermuteAndComb {
    fun <T> getPermutations(list: List<T>): List<List<T>> {
        val result = mutableListOf<List<T>>()
        val used = BooleanArray(list.size)

        fun backtrack(current: MutableList<T>) {
            if (current.size == list.size) {
                result.add(ArrayList(current))
                return
            }

            for (i in list.indices) {
                if (used[i]) continue

                current.add(list[i])
                used[i] = true

                backtrack(current)

                current.removeAt(current.size - 1)
                used[i] = false
            }
        }

        backtrack(mutableListOf())
        return result
    }

    fun <T> getCombinations(list: List<T>, r: Int): List<List<T>> {
        val result = mutableListOf<List<T>>()

        fun backtrack(start: Int, current: MutableList<T>) {
            if (current.size == r) {
                result.add(ArrayList(current))
                return
            }

            for (i in start until list.size) {
                current.add(list[i])
                backtrack(i + 1, current)
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0, mutableListOf())
        return result
    }
}