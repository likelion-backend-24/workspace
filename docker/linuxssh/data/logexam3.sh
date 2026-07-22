#!/bin/bash

LOG_FILE="/var/log/myapp.log"

# 색상 코드
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

log() {
    local level=$1
    shift
    local message="$*"
    local timestamp=$(date +'%Y-%m-%d %H:%M:%S')

    # 파일에 기록 (색상 없이)
    echo "[$timestamp] [$level] $message" >> "$LOG_FILE"

    # 화면에 출력 (색상 포함)
    case "$level" in
        ERROR)
            echo -e "${RED}[$timestamp] [$level] $message${NC}"
            ;;
        WARNING)
            echo -e "${YELLOW}[$timestamp] [$level] $message${NC}"
            ;;
        INFO)
            echo -e "${GREEN}[$timestamp] [$level] $message${NC}"
            ;;
        *)
            echo "[$timestamp] [$level] $message"
            ;;
    esac
}

# 사용 예시
log "INFO" "정상 작업"
log "WARNING" "주의가 필요한 상황"
log "ERROR" "오류 발생"