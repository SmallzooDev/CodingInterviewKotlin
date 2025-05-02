package problems.baekjoon.p1461

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (_, holdable) = readLine()!!.split(" ").map { it.toInt() }
    val plus: MutableList<Int> = mutableListOf()
    val minus: MutableList<Int> = mutableListOf()

    readLine()!!.split(" ").forEach {
        val tmp = it.toInt()
        if (tmp >= 0) {
            plus.add(tmp)
        } else {
            minus.add(abs(tmp))
        }
    }

    plus.sortByDescending { it }
    minus.sortByDescending { it }

    var maxDist = 0
    var result = 0

    for (i in plus.indices step holdable) {
        if (i == 0) {
            maxDist = max(maxDist, plus[i])
        }
        result += plus[i] * 2
    }

    for (i in minus.indices step holdable) {
        if (i == 0) {
            maxDist = max(maxDist, minus[i])
        }
        result += minus[i] * 2
    }

    result -= maxDist
    println(result)
    close()
}
