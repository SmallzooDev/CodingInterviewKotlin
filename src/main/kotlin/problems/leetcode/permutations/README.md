# leetcode permutations
---
> url : https://leetcode.com/problems/permutations/

```kotlin
    fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val used = BooleanArray(nums.size)

    fun backtrack(current: MutableList<Int>) {
        if (current.size == nums.size) {
            result.add(ArrayList(current)) // copy를 넣어야함 result.add(current) 했다가 레퍼런스때문에 변경됨
            return
        }

        for (i in nums.indices) {
            if (used[i]) continue

            used[i] = true
            current.add(nums[i])
            backtrack(current)
            current.removeAt(current.size - 1)
            used[i] = false
        }
    }

    backtrack(mutableListOf())
    return result
}
```

