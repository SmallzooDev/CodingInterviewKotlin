package problems.baekjoon.p1021

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val targets = readLine()!!.split(" ").map { it.toInt() }

    val deque = mutableListOf<Int>()
    for (i in 1..n) {
        deque.add(i)
    }

    var totalOperations = 0

    for (target in targets) {
        val targetIndex = deque.indexOf(target)

        if (targetIndex == 0) {
            deque.removeAt(0)
        } else {
            val leftRotations = targetIndex
            val rightRotations = deque.size - targetIndex

            if (leftRotations <= rightRotations) {
                repeat(leftRotations) {
                    val first = deque.removeAt(0)
                    deque.add(first)
                }
                totalOperations += leftRotations
            } else {
                repeat(rightRotations) {
                    val last = deque.removeAt(deque.size - 1)
                    deque.add(0, last)
                }
                totalOperations += rightRotations
            }

            deque.removeAt(0)
        }
    }

    println(totalOperations)
}
