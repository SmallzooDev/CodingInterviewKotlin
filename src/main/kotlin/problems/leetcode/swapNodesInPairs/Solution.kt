package problems.leetcode.swapNodesInPairs

import problems.leetcode.addTwoNumbers.ListNode

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head;

        var nextNode = head.next
        head.next = swapPairs(nextNode?.next)
        nextNode?.next = head
        return nextNode
    }
}