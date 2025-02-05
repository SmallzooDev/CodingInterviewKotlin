package problems.leetcode.maximumDepthOfBinaryTree

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var depth = 0

        while (!queue.isEmpty()) {
            depth += 1
            val qSize = queue.size
            for (i in 0 until qSize) {
                val cur = queue.poll()
                if (cur.left != null) queue.add(cur.left)
                if (cur.right != null) queue.add(cur.right)
            }
        }
        return depth
    }
}
