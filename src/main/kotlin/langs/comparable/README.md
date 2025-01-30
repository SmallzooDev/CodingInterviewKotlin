# Comparable 정리

### 기본 Comparable

- 자바와 동일

```kotlin
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

data class Person(val name: String, val age: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return this.age - other.age  // 나이 오름차순 정렬
    }
}

fun main() {
    val people = listOf(
        Person("Alice", 30),
        Person("Bob", 25),
        Person("Charlie", 35)
    )

    val sortedList = people.sorted()  // Comparable 기준으로 정렬
    println(sortedList)  // [Person(name=Bob, age=25), Person(name=Alice, age=30), Person(name=Charlie, age=35)]
}
```

반환값 Int

1. 양수 : 현재 객체가 비교 대상보다 큼
2. 0 : 같음
3. 음수 : 작음

### 기본 Comparator

- 마찬가지로 자바와 동일
- `compareBy()` -> Comparator반환하는 함수

```kotlin
interface Comparator<in T> {
    fun compare(o1: T, o2: T): Int
}

data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(
        Person("Alice", 30),
        Person("Bob", 25),
        Person("Charlie", 30)
    )

    // 나이순으로 먼저 정렬하고, 나이가 같으면 이름순으로 정렬
    val sortedList = people.sortedWith(
        compareBy<Person> { it.age }.thenBy { it.name }
    )

    println(sortedList)
    // [Person(name=Bob, age=25), Person(name=Alice, age=30), Person(name=Charlie, age=30)]
}
```

| 함수명                      | 기능                                              | 반환값                     |
|--------------------------|-------------------------------------------------|-------------------------|
| `sortedBy`               | 주어진 속성에 대해 **오름차순** 정렬                          | 새 리스트 반환                |
| `sortedByDescending`     | 주어진 속성에 대해 **내림차순** 정렬                          | 새 리스트 반환                |
| `sortedWith`             | 사용자 정의 **`Comparator`** 또는 **람다식** 기반으로 정렬      | 새 리스트 반환                |
| `sorted`                 | 기본 정렬 기준(즉, 객체가 `Comparable`을 구현한 경우)에 따라 정렬    | 새 리스트 반환                |
| `sortBy`                 | 주어진 속성에 대해 오름차순 정렬 (원본 리스트 변경)                  | 정렬된 **원본 리스트**          |
| `sortByDescending`       | 주어진 속성에 대해 내림차순 정렬 (원본 리스트 변경)                  | 정렬된 **원본 리스트**          |
| `sortWith`               | 사용자 정의 `Comparator`로 정렬 (원본 리스트 변경)             | 정렬된 **원본 리스트**          |
| `compareBy`              | **여러 속성**을 결합하여 **오름차순** 정렬 기준 `Comparator`를 반환 | `Comparator` 반환         |
| `compareByDescending`    | **여러 속성**을 결합하여 **내림차순** 정렬 기준 `Comparator`를 반환 | `Comparator` 반환         |
| `thenBy`                 | 이전 정렬 기준이 같은 경우 **추가 오름차순 기준**을 지정              | `Comparator` 반환         |
| `thenByDescending`       | 이전 정렬 기준이 같은 경우 **추가 내림차순 기준**을 지정              | `Comparator` 반환         |
| `maxOf`, `maxOfOrNull`   | 컬렉션에서 주어진 속성에 대한 최대값 반환. **`null` 허용**          | 최대값 반환 (없을 경우 `null`)   |
| `minOf`, `minOfOrNull`   | 컬렉션에서 주어진 속성에 대한 최소값 반환. **`null` 허용**          | 최소값 반환 (없을 경우 `null`)   |
| `maxByOrNull`            | 주어진 람다 조건에 맞는 최대값을 가진 객체 반환 (컬렉션이 비어있으면 `null`) | 최대값을 가진 객체 또는 `null`    |
| `minByOrNull`            | 주어진 람다 조건에 맞는 최소값을 가진 객체 반환 (컬렉션이 비어있으면 `null`) | 최소값을 가진 객체 또는 `null`    |
| `reversed()`             | 기존 정렬 결과를 뒤집어 반환                                | 새 리스트 반환                |
| `shuffled()`             | 리스트를 무작위로 섞어 반환                                 | 새 리스트 반환                |
| `distinctBy`             | 주어진 속성의 중복을 제거한 후 정렬                            | 중복 제거된 새 리스트 반환         |
| `takeWhile`, `dropWhile` | 주어진 조건을 만족하는 동안 요소를 반환하거나 제외                    | 부분 리스트 반환               |
| `partition`              | 주어진 조건에 따라 컬렉션을 두 개의 리스트로 나눔                    | `(리스트1, 리스트2)`로 반환      |
| `sortedArray`            | 배열을 오름차순 정렬한 새 배열 반환 (배열 전용)                    | 새 배열 반환                 |
| `sortedArrayDescending`  | 배열을 내림차순 정렬한 새 배열 반환 (배열 전용)                    | 새 배열 반환                 |
| `withIndex().sortedBy`   | 인덱스와 값을 함께 비교하여 정렬                              | 새 리스트 반환 (인덱스 포함)       |
| `map { ... }.sortedBy`   | 속성 값 변환 후 정렬                                    | 변환된 속성을 기준으로 정렬된 리스트 반환 |
| `asSequence().sortedBy`  | 시퀀스로 변환한 후 정렬                                   | 정렬된 시퀀스 반환              |