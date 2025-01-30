# leetcode reverseLinkedListIi
---
> url : https://leetcode.com/problems/reverse-linked-list-ii/description/

```kotlin
        for (i in 1 until left) {
    prev = prev?.next
}

val start = prev?.next
var end = start?.next

for (i in 0 until right - left) {
    start?.next = end?.next
    end?.next = prev?.next
    prev?.next = end
    end = start?.next
}
```