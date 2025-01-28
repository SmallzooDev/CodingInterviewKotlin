# Kotlin Coding Interview Practices
---

### init.sh에 실행권한 주기

```bash
chmod +x init.sh
```

### url 붙여넣기로 문제 패키지와 README 만들기

```bash
./init.sh https://leetcode.com/problems/reverse-string/description/
```

### 아래와 같은 구조로 패키지가 생성됩니다.

```
src/
└── main/
    └── kotlin/
        └── problems/
            └── leetcode/
                └── reverseString/
                    └── Solution.kt
                    └── README.md
```