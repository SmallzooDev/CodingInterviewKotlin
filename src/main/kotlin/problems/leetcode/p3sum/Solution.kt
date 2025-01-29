package problems.leetcode.p3sum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                when {
                    sum == 0 -> {
                        // 합이 0인 조합 추가
                        result.add(listOf(nums[i], nums[left], nums[right]))

                        // 중복된 값 건너뛰기
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        // 다음 값으로 이동
                        left++
                        right--
                    }

                    sum < 0 -> left++ // 합이 0보다 작으면 left 포인터 증가
                    else -> right--   // 합이 0보다 크면 right 포인터 감소
                }
            }
        }

        return result
    }
}
