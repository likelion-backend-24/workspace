#!/bin/bash
set -e

LOG_FILE="/var/log/backup.log"

log() {
    echo "[$(date +'%Y-%m-%d %H:%M:%S')] $*" | tee -a "$LOG_FILE"
}

log "백업 시작"

# 데이터베이스 백업
mysqldump -u root -p mydb > "/backup/mydb-$(date +%Y%m%d).sql"

# 파일 백업
tar -czf "/backup/files-$(date +%Y%m%d).tar.gz" /var/www/html

log "백업 완료"
