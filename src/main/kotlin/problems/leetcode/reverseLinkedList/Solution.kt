package problems.leetcode.reverseLinkedList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        // 시작 노드 반환용
        val newHead = reverseList(head.next)
        head.next?.next = head
        head.next = null

        return newHead
    }
}
