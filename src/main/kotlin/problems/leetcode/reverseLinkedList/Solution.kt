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
        // 5 -> 4
        head.next?.next = head
        // 4 -> null 직전 스택프레임(head가 3으로 호출된)에서 next를 연결해줌
        head.next = null

        return newHead
    }
}
