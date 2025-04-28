package problems.baekjoon.p10974

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val nums = IntArray(n) { it + 1 }
    val sb = StringBuilder()

    sb.appendLine(nums.joinToString(" "))

    while (getNextPermutation(nums)) {
        sb.appendLine(nums.joinToString(" "))
    }

    print(sb)
    close()
}

fun getNextPermutation(arr: IntArray): Boolean {
    // 1단계: 뒤에서부터 탐색하여 오름차순이 깨지는 위치 찾기
    var i = arr.size - 1
    // 예시: arr = [1,2,4,3]
    // i=3일 때, arr[2]=4, arr[3]=3이므로 arr[2] > arr[3], i--
    // i=2일 때, arr[1]=2, arr[2]=4이므로 arr[1] < arr[2], 반복 종료
    // 최종 i=2
    while (i > 0 && arr[i - 1] >= arr[i]) i--

    // 내림차순으로 완전히 정렬된 상태면 마지막 순열
    // 예시: arr = [3,2,1]이면 i=0이 되어 false 반환
    if (i <= 0) return false

    // 2단계: arr[i-1]보다 큰 값 중 가장 오른쪽에 있는 값 찾기
    var j = arr.size - 1
    // 예시: arr = [1,2,4,3], i=2, i-1=1, arr[i-1]=2
    // j=3일 때, arr[3]=3 > arr[1]=2, 반복 종료
    // 최종 j=3
    while (arr[j] <= arr[i - 1]) j--

    // 3단계: arr[i-1]과 arr[j] 교환
    // 예시: arr = [1,2,4,3], i-1=1, j=3
    // arr[1]=2와 arr[3]=3 교환
    // 결과: arr = [1,3,4,2]
    arr[i - 1] = arr[j].also { arr[j] = arr[i - 1] }

    // 4단계: i부터 끝까지 뒤집기 (오름차순으로 정렬)
    // 예시: arr = [1,3,4,2], i=2
    // i=2부터 끝까지 [4,2]를 뒤집어 [2,4]로 만듦
    // 결과: arr = [1,3,2,4]
    j = arr.size - 1
    while (i < j) {
        arr[i] = arr[j].also { arr[j] = arr[i] }
        i++
        j--
    }

    return true
}

fun permute(list: MutableList<Int>, start: Int, end: Int) {
    // 기저 조건: 모든 위치가 결정되었을 때
    // 현재 순열을 출력하고 종료
    if (start == end) {
        println(list.joinToString(" "))
        return
    }

    // 현재 위치(start)에 가능한 모든 원소 배치해보기
    for (i in start..end) {
        // start 위치와 i 위치의 원소 교환
        // 예: list=[1,2,4,3], start=0, i=0 → 교환 후 [1,2,4,3] (변화 없음)
        list[start] = list[i].also { list[i] = list[start] }

        // 다음 위치(start+1)부터 재귀적으로 순열 생성
        // 예: permute([1,2,4,3], 1, 3) 호출
        permute(list, start + 1, end)

        // 백트래킹: 원래 상태로 복원
        // 예: 다시 list=[1,2,4,3]로 복원
        list[start] = list[i].also { list[i] = list[start] }
    }
}
