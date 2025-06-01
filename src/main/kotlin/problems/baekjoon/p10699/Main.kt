package problems.baekjoon.p10699

import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.ZoneId

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val today = LocalDate.now(ZoneId.of("Asia/Seoul"))

    println(today)

    close()
}
