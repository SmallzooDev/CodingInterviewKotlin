# leetcode reorderDataInLogFiles
---
url : https://leetcode.com/problems/reorder-data-in-log-files/description/

### Partition

- 입력: 하나의 리스트와 조건(predicate).
- 출력: 두 개의 리스트로 이루어진 Pair 객체.
- 첫 번째 리스트: 조건을 만족하는 요소들.
- 두 번째 리스트: 조건을 만족하지 않는 요소들.

```kotlin
fun <T> Iterable<T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>>
```

Iterable의 element T를 받아서 Boolean을 반환하는 조건식을 받아, 조건을 만족하는 첫번째 리스트와, 만족하지 않는 두 번째 리스트를 반환

### sortedWith, sortWith 차이점

- `sortedWith`: 새로운 리스트를 반환 (원본 유지).
- `sortWith`: 원본 리스트를 정렬 (원본 변경).

### compareBy

compareBy는 정렬 기준을 정의하는 Comparator를 간결하게 생성하는 유틸리티 함수.

단일 기준 또는 다중 기준으로 정렬해야 할 때 가독성을 높여준다.

```kotlin
val sortedNames = names.sortedWith(compareBy { it.length })
```

```kotlin
data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Charlie", 30),
    Person("Alice", 25),
    Person("Alice", 20)
)

val sortedPeople = people.sortedWith(
    compareBy(
        { it.name },  // 첫 번째 기준: 이름 (오름차순)
    { it.age }    // 두 번째 기준: 나이 (오름차순)
))
```