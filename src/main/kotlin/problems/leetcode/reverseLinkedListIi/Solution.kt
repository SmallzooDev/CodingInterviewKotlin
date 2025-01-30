package problems.leetcode.reverseLinkedListIi

import problems.leetcode.addTwoNumbers.ListNode


class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null || left == right) return head

        val dummy = ListNode(0).apply { next = head }
        var prev: ListNode? = dummy
        for (i in 1 until left) {
            prev = prev?.next
        }

        val start = prev?.next
        var end = start?.next

        for (i in 0 until right - left) {
            start?.next = end?.next
            end?.next = prev?.next
            prev?.next = end
            end = start?.next
        }

        return dummy.next
    }
}
