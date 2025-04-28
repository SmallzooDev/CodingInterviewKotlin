package problems.baekjoon.p1759

import java.io.BufferedReader
import java.io.InputStreamReader

fun List<Char>.isValidPassword(): Boolean {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    val vowelCount = count { it in vowels }
    val consonantCount = count { it !in vowels && it in 'a'..'z' }

    return vowelCount >= 1 && consonantCount >= 2
}

fun MutableList<Char>.getPasswords(result: MutableList<Char> = mutableListOf(), idx: Int = 0, limit: Int) {
    if (result.size == limit) {
        if (result.isValidPassword()) {
            println(result.joinToString(""))
        }
        return
    }

    for (i in idx until size) {
        result.add(this[i])
        getPasswords(result, i + 1, limit)
        result.removeLast()
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val level = input[0]
    val charList = readLine()!!.split(" ").map { it[0] }.toMutableList().apply { sort() }

    charList.getPasswords(limit = level)

    close()
}