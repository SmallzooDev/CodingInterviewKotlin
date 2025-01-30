package org.example.datastructures.queueStack

import java.util.LinkedList
import java.util.Queue

class QueueStack {
    val queue: Queue<Int> = LinkedList()

    fun push(x: Int) {
        queue.add(x)
        for (i in 1 until queue.size) {
            queue.add(queue.remove())
        }
    }

    fun pop(): Int {
        return queue.remove()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}