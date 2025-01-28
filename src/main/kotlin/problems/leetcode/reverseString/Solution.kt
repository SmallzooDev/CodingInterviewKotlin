package org.example.problems.leetcode.reverseString

class Solution {
    fun reverseString(s: CharArray): Unit {
        s.reverse()
    }

    fun reverseString2(s: CharArray): Unit {
        var temp: Char
        var start = 0
        var end = s.size - 1
        while (start < end) {
            temp = s[start]
            s[start] = s[end]
            s[end] = temp
            start++
            end--
        }
    }

    fun reverseString3(s: CharArray): Unit {
        var start = 0
        var end = s.size - 1
        while (start < end) {
            // s[end] 반환, also 블럭 실행, 대입 순서로 일어난다고함
            s[start] = s[end].also { s[end] = s[start] }
            start++
            end--
        }
    }
}