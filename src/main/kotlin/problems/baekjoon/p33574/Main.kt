package problems.baekjoon.p33574

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val q = readLine().toInt()
    val queries = mutableListOf<List<Int>>()

    repeat(q) {
        queries.add(readLine().split(' ').map { it.toInt() })
    }

    var lastSort = -1
    for (i in queries.indices) {
        if (queries[i][0] == 1) lastSort = i
    }

    val s = mutableListOf<Int>()

    if (lastSort == -1) {
        for (query in queries) {
            if (query[0] == 2) {
                val x = query[1]
                val t = query[2]
                s.add(x, t)
            }
        }
    } else {
        for (i in 0 until lastSort) {
            if (queries[i][0] == 2) {
                val x = queries[i][1]
                val t = queries[i][2]
                s.add(x, t)
            }
        }

        if (queries[lastSort][1] == 1) {
            s.sort()
        } else {
            s.sortDescending()
        }

        for (i in lastSort + 1 until q) {
            if (queries[i][0] == 2) {
                val x = queries[i][1]
                val t = queries[i][2]
                s.add(x, t)
            }
        }
    }

    println(s.size)
    if (s.isNotEmpty()) {
        println(s.joinToString(" "))
    }

    close()
}