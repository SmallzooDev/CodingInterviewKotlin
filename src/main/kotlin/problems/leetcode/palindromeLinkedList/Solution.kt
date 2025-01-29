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
}
