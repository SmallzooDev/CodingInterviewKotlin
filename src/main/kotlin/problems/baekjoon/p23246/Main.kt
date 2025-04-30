package problems.baekjoon.p23246

import java.io.BufferedReader
import java.io.InputStreamReader

data class Climber(
    val id: Int,
    val lead: Int,
    val speed: Int,
    val bouldering: Int,
): Comparable<Climber> {
    private val total: Int
        get() = lead * speed * bouldering
    private val sum: Int
        get() = lead + speed + bouldering

    override fun compareTo(other: Climber): Int {
        return compareValuesBy(this, other,
            {it.total}, {it.sum}, {it.id}
        )
    }
}



fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val climbers: MutableList<Climber> = mutableListOf()
    repeat(n) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }
        climbers.add(Climber(tmp[0], tmp[1], tmp[2], tmp[3]))
    }
    val sortedClimbers = climbers.sorted()
    println(sortedClimbers.take(3).joinToString(" ") { it.id.toString() })
    close()
}

