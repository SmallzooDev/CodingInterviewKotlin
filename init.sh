#!/bin/bash

url=$1

if [ -z "$url" ]; then
    echo "사용법: ./create-problem.sh <문제_URL>"
    exit 1
fi

# URL에서 사이트 타입 확인
if [[ $url == *"leetcode.com"* ]]; then
    site="leetcode"
    # URL에서 문제 이름 추출 (마지막 / 이후, description 이전)
    problem_name=$(echo $url | sed -E 's/.*\/problems\/([^/]+)\/description.*/\1/')
elif [[ $url == *"acmicpc.net"* ]]; then
    site="baekjoon"
    # URL에서 문제 번호 추출
    problem_name=$(echo $url | sed -E 's/.*\/problem\/([0-9]+).*/\1/')
else
    echo "지원하지 않는 사이트입니다. (지원: leetcode, acmicpc.net)"
    exit 1
fi

# 기본 디렉토리 경로
base_dir="src/main/kotlin/problems/$site/$problem_name"

# 디렉토리 생성
mkdir -p "$base_dir"

# Solution.kt 파일 생성
cat > "$base_dir/Solution.kt" << EOF
package problems.$site.$problem_name

class Solution {
    
}
EOF

# README.md 파일 생성
cat > "$base_dir/README.md" << EOF
# ${site} ${problem_name}
---
url : ${url}
EOF

echo "문제 생성 완료: $base_dir"