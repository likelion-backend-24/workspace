#!/bin/bash

# AND 연산자 (&&): 앞 명령 성공 시에만 뒷 명령 실행
mkdir /tmp/testdir && cd /tmp/testdir && touch file.txt

# OR 연산자 (||): 앞 명령 실패 시에만 뒷 명령 실행
ping -c 1 google.com || echo "네트워크 연결 실패"

# 복합 사용
mkdir /tmp/backup || { echo "디렉토리 생성 실패"; exit 1; }
