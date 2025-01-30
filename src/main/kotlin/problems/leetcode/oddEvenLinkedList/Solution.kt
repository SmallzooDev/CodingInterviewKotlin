package problems.leetcode.oddEvenLinkedList

import problems.leetcode.addTwoNumbers.ListNode

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        var odd: ListNode = head
        var even: ListNode? = head.next
        val evenHead = even

        while (even?.next != null) {
            odd.next = even.next
            odd = odd.next!!

            even.next = odd.next
            even = even.next
        }

        odd.next = evenHead

        return head
    }
}
