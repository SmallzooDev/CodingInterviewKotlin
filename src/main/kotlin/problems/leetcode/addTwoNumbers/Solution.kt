package problems.leetcode.addTwoNumbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var currListFirst = l1
        var currListSecond = l2
        var current = dummy
        var carry = 0

        while (currListFirst != null || currListSecond != null) {
            val tmpFirst = currListFirst?.`val` ?: 0
            val tmpSecond = currListSecond?.`val` ?: 0
            val sum = tmpFirst + tmpSecond + carry

            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!!

            if (currListFirst != null) currListFirst = currListFirst.next
            if (currListSecond != null) currListSecond = currListSecond.next
        }

        if (carry > 0) {
            current.next = ListNode(carry)
        }

        return dummy.next
    }

    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var carry = 0
        var currentListFirst = l1
        var currentListSecond = l2

        while (currentListFirst != null || currentListSecond != null || carry > 0) {
            val sum = (currentListFirst?.`val` ?: 0) + (currentListSecond?.`val` ?: 0) + carry
            carry = sum / 10

            current.next = ListNode(sum % 10).also { current = it }

            currentListFirst = currentListFirst?.next
            currentListSecond = currentListSecond?.next
        }

        return dummy.next
    }
}
