package problems.leetcode.mergeTwoSortedLists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var firstNodePointer = list1
        var secondNodePointer = list2
        var dummy = ListNode(0)
        var currentPointer = dummy

        while (firstNodePointer != null && secondNodePointer != null) {
            if (firstNodePointer.`val` < secondNodePointer.`val`) {
                currentPointer.next = firstNodePointer
                firstNodePointer = firstNodePointer.next
            } else {
                currentPointer.next = secondNodePointer
                secondNodePointer = secondNodePointer.next
            }
            currentPointer = currentPointer.next!!
        }

        currentPointer.next = firstNodePointer ?: secondNodePointer

        return dummy.next
    }

    fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists2(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists2(list1, list2.next)
            list2
        }
    }
}
