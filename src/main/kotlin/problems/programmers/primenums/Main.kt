package org.example.problems.programmers.primenums

class Solution {
    fun solution(n: Int, k: Int): Int {
        return n.toString(k)
            .split("0")
            .filter { it.isNotEmpty() && it != "1" }
            .count { isPrime(it.toLong()) }
    }

    private fun isPrime(n: Long): Boolean {
        if (n <= 1) return false
        if (n == 2L) return true
        if (n % 2 == 0L) return false

        var i = 3L
        while (i * i <= n) {
            if (n % i == 0L) return false
            i += 2
        }
        return true
    }
}