# leetcode combinationSum
---
> url : https://leetcode.com/problems/combination-sum/description/

log for comb2 func

```
현재 조합: [], 남은 타겟: 8
숫자 추가: 2 (현재 조합: [])
현재 조합: [2], 남은 타겟: 6
숫자 추가: 2 (현재 조합: [2])
현재 조합: [2, 2], 남은 타겟: 4
숫자 추가: 2 (현재 조합: [2, 2])
현재 조합: [2, 2, 2], 남은 타겟: 2
숫자 추가: 2 (현재 조합: [2, 2, 2])
현재 조합: [2, 2, 2, 2], 남은 타겟: 0
조합 완성: [2, 2, 2, 2]
백트래킹: 2 제거 후 현재 조합: [2, 2, 2]
타겟 초과: 3 (현재 남은 타겟: 2)
타겟 초과: 5 (현재 남은 타겟: 2)
백트래킹: 2 제거 후 현재 조합: [2, 2]
숫자 추가: 3 (현재 조합: [2, 2])
현재 조합: [2, 2, 3], 남은 타겟: 1
타겟 초과: 3 (현재 남은 타겟: 1)
타겟 초과: 5 (현재 남은 타겟: 1)
백트래킹: 3 제거 후 현재 조합: [2, 2]
타겟 초과: 5 (현재 남은 타겟: 4)
백트래킹: 2 제거 후 현재 조합: [2]
숫자 추가: 3 (현재 조합: [2])
현재 조합: [2, 3], 남은 타겟: 3
숫자 추가: 3 (현재 조합: [2, 3])
현재 조합: [2, 3, 3], 남은 타겟: 0
조합 완성: [2, 3, 3]
백트래킹: 3 제거 후 현재 조합: [2, 3]
타겟 초과: 5 (현재 남은 타겟: 3)
백트래킹: 3 제거 후 현재 조합: [2]
숫자 추가: 5 (현재 조합: [2])
현재 조합: [2, 5], 남은 타겟: 1
타겟 초과: 5 (현재 남은 타겟: 1)
백트래킹: 5 제거 후 현재 조합: [2]
백트래킹: 2 제거 후 현재 조합: []
숫자 추가: 3 (현재 조합: [])
현재 조합: [3], 남은 타겟: 5
숫자 추가: 3 (현재 조합: [3])
현재 조합: [3, 3], 남은 타겟: 2
타겟 초과: 3 (현재 남은 타겟: 2)
타겟 초과: 5 (현재 남은 타겟: 2)
백트래킹: 3 제거 후 현재 조합: [3]
숫자 추가: 5 (현재 조합: [3])
현재 조합: [3, 5], 남은 타겟: 0
조합 완성: [3, 5]
백트래킹: 5 제거 후 현재 조합: [3]
백트래킹: 3 제거 후 현재 조합: []
숫자 추가: 5 (현재 조합: [])
현재 조합: [5], 남은 타겟: 3
타겟 초과: 5 (현재 남은 타겟: 3)
백트래킹: 5 제거 후 현재 조합: []
[[2, 2, 2, 2], [2, 3, 3], [3, 5]]
```