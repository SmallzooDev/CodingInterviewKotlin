package org.example.datastructures.bplustree

class BPlusTree<K : Comparable<K>, V>(private val order: Int) {
    private var root: Node<K, V> = LeafNode()

    private interface Node<K : Comparable<K>, V> {
        val keys: MutableList<K>
        fun insert(key: K, value: V): SplitResult<K, V>?
        fun find(key: K): V?
        fun delete(key: K): Boolean
    }

    private data class SplitResult<K : Comparable<K>, V>(val key: K, val rightNode: Node<K, V>)

    private inner class InternalNode : Node<K, V> {
        override val keys = mutableListOf<K>()
        val children = mutableListOf<Node<K, V>>()

        override fun insert(key: K, value: V): SplitResult<K, V>? {
            val index = keys.binarySearch(key).let { if (it < 0) -(it + 1) else it }
            val splitResult = children[index].insert(key, value) ?: return null

            keys.add(index, splitResult.key)
            children.add(index + 1, splitResult.rightNode)

            return if (keys.size >= order) split() else null
        }

        private fun split(): SplitResult<K, V> {
            val mid = keys.size / 2
            val promoteKey = keys[mid]
            val rightNode = InternalNode().apply {
                keys.addAll(this@InternalNode.keys.subList(mid + 1, keys.size))
                children.addAll(this@InternalNode.children.subList(mid + 1, children.size))
            }

            keys.subList(mid, keys.size).clear()
            children.subList(mid + 1, children.size).clear()

            return SplitResult(promoteKey, rightNode)
        }

        override fun find(key: K): V? {
            val index = keys.binarySearch(key).let { if (it >= 0) it + 1 else -(it + 1) }
            return children[index].find(key)
        }

        override fun delete(key: K): Boolean {
            val index = keys.binarySearch(key)
            val childIndex = if (index >= 0) index + 1 else -(index + 1)
            val deleted = children[childIndex].delete(key)

            if (deleted && children[childIndex].keys.isEmpty()) {
                children.removeAt(childIndex)
                if (index >= 0) keys.removeAt(index)
            }
            return deleted
        }
    }

    private inner class LeafNode : Node<K, V> {
        override val keys = mutableListOf<K>()
        val values = mutableListOf<V>()
        var prev: LeafNode? = null
        var next: LeafNode? = null

        override fun insert(key: K, value: V): SplitResult<K, V>? {
            val index = keys.binarySearch(key).let {
                if (it < 0) -(it + 1) else {
                    values[it] = value
                    return null
                }
            }

            keys.add(index, key)
            values.add(index, value)

            return if (keys.size >= order) split() else null
        }

        private fun split(): SplitResult<K, V> {
            val mid = keys.size / 2
            val rightNode = LeafNode().apply {
                keys.addAll(this@LeafNode.keys.subList(mid, keys.size))
                values.addAll(this@LeafNode.values.subList(mid, values.size))
                next = this@LeafNode.next
                prev = this@LeafNode
            }

            next?.prev = rightNode
            next = rightNode
            keys.subList(mid, keys.size).clear()
            values.subList(mid, values.size).clear()
            return SplitResult(rightNode.keys.first(), rightNode)
        }

        override fun find(key: K): V? {
            val index = keys.binarySearch(key)
            return if (index >= 0) values[index] else null
        }

        override fun delete(key: K): Boolean {
            val index = keys.binarySearch(key)
            if (index < 0) return false
            keys.removeAt(index)
            values.removeAt(index)
            return true
        }
    }

    fun insert(key: K, value: V) {
        val splitResult = root.insert(key, value)
        if (splitResult != null) {
            root = InternalNode().apply {
                keys.add(splitResult.key)
                children.add(root)
                children.add(splitResult.rightNode)
            }
        }
    }

    fun find(key: K): V? = root.find(key)

    fun delete(key: K) {
        root.delete(key)
        if (root is InternalNode && root.keys.isEmpty()) {
            root = (root as InternalNode).children.first()
        }
    }
}
