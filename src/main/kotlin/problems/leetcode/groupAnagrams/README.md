# leetcode groupAnagrams
---
url : https://leetcode.com/problems/group-anagrams/description/

### fold

초기값 있는 `reduce()`

그 외에는 reduce처럼 람다의 계산 결과가 다음 요소를 계산하는 시점의 acc로 동일

```kotlin
fun <T, R> Iterable<T>.fold(
    initial: R,              // 초기값
    operation: (acc: R, T) -> R // 누적값(acc)과 현재 요소(T)를 처리하는 람다
): R

val words = listOf("apple", "banana", "apple", "orange", "banana")
val wordCount = words.fold(mutableMapOf<String, Int>()) { acc, word ->
    acc[word] = acc.getOrDefault(word, 0) + 1
    acc
}
println(wordCount) // {apple=2, banana=2, orange=1}

val words = listOf("Kotlin", "is", "fun")
val sentence = words.fold("") { acc, word -> "$acc $word" }.trim()
println(sentence) // Kotlin is fun
```

