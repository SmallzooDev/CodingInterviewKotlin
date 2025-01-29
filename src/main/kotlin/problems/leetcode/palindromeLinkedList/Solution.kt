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

    fun isPalindrome3(head: ListNode?): Boolean {
        if (head == null || head.next == null) return true

        // Step 1: 중간 지점 찾기 (빠른/느린 포인터)
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Step 2: 중간 이후 리스트 뒤집기
        var prev: ListNode? = null
        var curr = slow
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        // Step 3: 앞쪽과 뒤쪽 비교
        var left = head
        var right = prev
        while (right != null) {
            if (left?.`val` != right.`val`) return false
            left = left?.next
            right = right.next
        }

        return true
    }
}
