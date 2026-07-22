#!/bin/bash
set -x  # 디버그 모드 활성화

NAME="Alice"
echo "Hello, $NAME"

for i in {1..3}; do
    echo "Number: $i"
done

set +x  # 디버그 모드 비활성화
echo "디버그 종료"
