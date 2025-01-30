package problems.leetcode.mergeKSortedLists

import problems.leetcode.addTwoNumbers.ListNode
import java.util.PriorityQueue

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val priorityQueue = PriorityQueue<ListNode> { o1, o2 ->
            o1.`val` - o2.`val`
        }

        lists.forEach {
            if (it != null) {
                priorityQueue.add(it)
            }
        }

        val dummy = ListNode(0)
        var current = dummy

        while (priorityQueue.isNotEmpty()) {
            val smallest = priorityQueue.poll()
            current.next = smallest
            current = current.next!!

            if (smallest.next != null) {
                priorityQueue.add(smallest.next)
            }
        }
        return dummy.next
    }
}
