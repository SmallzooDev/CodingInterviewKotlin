package problems.baekjoon.p1008

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    println(division(a, b))
    close()
}

fun division(a: Int, b: Int): String {
    val mathContext = MathContext(20, RoundingMode.HALF_UP)
    val bigA = BigDecimal(a)
    val bigB = BigDecimal(b)

    return bigA.divide(bigB, mathContext).stripTrailingZeros().toPlainString()
}