#!/bin/bash
set -e  # 명령 실패 시 스크립트 즉시 종료

echo "작업 시작"
mkdir /tmp/mydir
cd /tmp/mydir
cp important-file.txt backup.txt  # 파일이 없으면 여기서 중단
echo "작업 완료"  # 위 명령이 실패하면 실행되지 않음
