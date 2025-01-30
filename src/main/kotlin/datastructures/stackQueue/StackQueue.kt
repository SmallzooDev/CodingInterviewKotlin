package org.example.datastructures.stackQueue

import java.util.Deque
import java.util.ArrayDeque

class StackQueue {
    val input: Deque<Int> = ArrayDeque()
    val output = ArrayDeque<Int>()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        peek()
        return output.pop()
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop())
            }
        }
        return output.peek()
    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }
}