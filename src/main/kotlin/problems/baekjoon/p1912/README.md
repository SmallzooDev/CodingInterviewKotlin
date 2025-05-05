# baekjoon p1912
---
> url : https://www.acmicpc.net/problem/1912

## 초기화

max_so_far = 10 (첫 번째 요소)
max_ending_here = 10 (첫 번째 요소)

## 각 단계별 진행

### 1단계 - 두 번째 요소 (-4)

max_ending_here = max(-4, 10+(-4)) = max(-4, 6) = 6

- 의미: "-4만 선택하는 것"과 "이전까지의 합 10에 -4를 더하는 것" 중 큰 값 선택

max_so_far = max(10, 6) = 10

- 의미: 이전까지의 최대값과 현재 위치까지의 최대값 중 큰 값 선택

### 2단계 - 세 번째 요소 (3)

max_ending_here = max(3, 6+3) = max(3, 9) = 9

- 의미: "3만 선택"과 "이전까지의 합 6에 3을 더하기" 중 선택

max_so_far = max(10, 9) = 10

여전히 10이 최대값

### 3단계 - 네 번째 요소 (1)

max_ending_here = max(1, 9+1) = max(1, 10) = 10
max_so_far = max(10, 10) = 10

### 4단계 - 다섯 번째 요소 (5)

max_ending_here = max(5, 10+5) = max(5, 15) = 15
max_so_far = max(10, 15) = 15

드디어 최대값이 갱신됨!

### 5단계 - 여섯 번째 요소 (6)

max_ending_here = max(6, 15+6) = max(6, 21) = 21
max_so_far = max(15, 21) = 21

최대값 다시 갱신

### 6단계 - 일곱 번째 요소 (-35)

max_ending_here = max(-35, 21+(-35)) = max(-35, -14) = -14

큰 음수값을 만나서 합계가 낮아짐

max_so_far = max(21, -14) = 21

하지만 전체 최대값은 그대로 유지

### 7단계 - 여덟 번째 요소 (12)

max_ending_here = max(12, -14+12) = max(12, -2) = 12

여기서 중요한 결정 발생: 이전 합계(-14)에 12를 더하는 것보다
12부터 새로 시작하는 것이 더 유리함

max_so_far = max(21, 12) = 21

### 8단계 - 아홉 번째 요소 (21)

max_ending_here = max(21, 12+21) = max(21, 33) = 33
max_so_far = max(21, 33) = 33

최대값 갱신!

### 9단계 - 열 번째 요소 (-1)

max_ending_here = max(-1, 33+(-1)) = max(-1, 32) = 32
max_so_far = max(33, 32) = 33

최종 결과
최대 부분합: 33 (8번째와 9번째 요소, 12+21=33)