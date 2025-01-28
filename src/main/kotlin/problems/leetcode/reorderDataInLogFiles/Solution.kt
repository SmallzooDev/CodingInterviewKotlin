package problems.leetcode.reorderDataInLogFiles

class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        var numList = mutableListOf<String>()
        var strList = mutableListOf<String>()
        logs.forEach {
            if (it.split(" ")[1].all { it.isDigit() }) {
                numList.add(it)
            } else {
                strList.add(it)
            }
        }

        strList.sortWith(
            Comparator { s1: String, s2: String ->
                val s1Id = s1.split(" ", limit = 2)
                val s2Id = s2.split(" ", limit = 2)
                val compared = s1Id[1].compareTo(s2Id[1])
                if (compared == 0) {
                    s1Id[0].compareTo(s2Id[0])
                } else {
                    compared
                }
            }
        )
        strList.addAll(numList)
        return strList.toTypedArray()
    }

    // partition 관련해서는 README 에 정리
    fun reorderLogFiles2(logs: Array<String>): Array<String> {
        val (strLogs, numLogs) = logs.partition { it.split(" ", limit = 2)[1].any { c -> c.isLetter() } }

        val sortedStrLogs = strLogs.sortedWith(
            compareBy(
                { it.substringAfter(" ") },
                { it.substringBefore(" ") }
            ))

        return (sortedStrLogs + numLogs).toTypedArray()
    }
}
