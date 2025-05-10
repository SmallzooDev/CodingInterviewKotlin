package problems.baekjoon.p2110

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val firstLine = readLine()!!.split(" ").map { it.toInt() }
    val n = firstLine[0]
    val c = firstLine[1]
    val houses: MutableList<Int> = mutableListOf()
    repeat(n) {
        houses.add(readLine()!!.toInt())
    }
    close()

    houses.sort()

    var left = 1
    var right = houses[n - 1] - houses[0]
    var result = 0

    while (left <= right) {
        val mid = (left + right) / 2

        if (canInstallAll(houses, mid, c)) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(result)
}

fun canInstallAll(list: MutableList<Int>, stp: Int, cnt: Int): Boolean {
    var count = 1
    var lastPosition = list[0]

    for (i in 1 until list.size) {
        val currentPosition = list[i]

        if (currentPosition - lastPosition >= stp) {
            count++
            lastPosition = currentPosition

            if (count >= cnt) {
                return true
            }
        }
    }

    return false
}
