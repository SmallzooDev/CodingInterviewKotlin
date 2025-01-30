package problems.leetcode.kClosestPointsToOrigin

import java.util.*

data class Point(var distance: Long, var point: IntArray)

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val priorityQueue = PriorityQueue<Point>(compareBy { a -> a.distance })

        for (point in points) {
            val distance = point[0].toLong() * point[0] + point[1].toLong() * point[1]
            priorityQueue.add(Point(distance, point))
        }

        val result = Array(k) {
            IntArray(2) { 0 }
        }

        for (i in 0 until k) {
            result[i] = priorityQueue.poll().point
        }

        return result
    }
}
