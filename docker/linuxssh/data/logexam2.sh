#!/bin/bash

LOG_FILE="/var/log/myapp.log"

# 로깅 함수
log() {
    local level=$1
    shift
    echo "[$(date +'%Y-%m-%d %H:%M:%S')] [$level] $*" | tee -a "$LOG_FILE"
}

# 사용 예시
log "INFO" "애플리케이션 시작"
log "DEBUG" "변수 VAR=$VAR"
log "ERROR" "파일을 찾을 수 없습니다: $FILE"
log "INFO" "작업 완료"
