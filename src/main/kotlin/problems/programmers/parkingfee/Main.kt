package org.example.problems.programmers.parkingfee

import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val baseTime = fees[0]
        val basePrice = fees[1]
        val perTime = fees[2]
        val perPrice = fees[3]

        val timeRecords = mutableMapOf<String, MutableList<Int>>()

        for (record in records) {
            val (timeStr, car, _) = record.split(" ")
            val (hour, minute) = timeStr.split(":").map { it.toInt() }
            val minutes = hour * 60 + minute
            timeRecords.computeIfAbsent(car) { mutableListOf() }.add(minutes)
        }

        val feeMap = timeRecords.mapValues { (_, times) ->
            val sortedTimes = times.sorted()
            var totalTime = 0

            for (i in sortedTimes.indices step 2) {
                val inTime = sortedTimes[i]
                val outTime = if (i + 1 < sortedTimes.size) sortedTimes[i + 1] else 23 * 60 + 59
                totalTime += outTime - inTime
            }

            if (totalTime <= baseTime) {
                basePrice
            } else {
                basePrice + ceil((totalTime - baseTime).toDouble() / perTime).toInt() * perPrice
            }
        }

        return feeMap.toSortedMap().values.toIntArray()
    }
}