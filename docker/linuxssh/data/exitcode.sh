#!/bin/bash

# 명령 실행
cp  exxxxx.sh dest22.txt

#echo $?



# 종료 코드 확인
if [ $? -eq 0 ]; then
    echo "복사 성공"
else
    echo "복사 실패"
    exit 1
fi
