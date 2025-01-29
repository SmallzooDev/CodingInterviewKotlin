package problems.leetcode.palindromeLinkedList

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var currentNode = head
        val stack = mutableListOf<Int>()

        while (currentNode != null) {
            stack.add(currentNode.`val`)
            currentNode = currentNode.next
        }

        currentNode = head
        while (currentNode != null) {
            if (stack.removeLast() != currentNode.`val`) {
                return false
            }
            currentNode = currentNode.next
        }

        return true
    }

    fun isPalindrome2(head: ListNode?): Boolean {
        if (head == null || head.next == null) return true

        val deque = ArrayDeque<Int>()
        var currentNode = head

        while (currentNode != null) {
            deque.addLast(currentNode.`val`)
            currentNode = currentNode.next
        }

        while (deque.size > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false
            }
        }

        return true
    }
}
