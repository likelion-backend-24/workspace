# 1) MySQL 공식 이미지
FROM mysql:8

# 2) 환경 변수 설정
ENV TZ=Asia/Seoul \
    DEBIAN_FRONTEND=noninteractive

# 3) tzdata 설치 (microdnf)
RUN microdnf -y install tzdata && \
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone && \
    microdnf clean all

# 4) MySQL 서버 실행 시 파라미터로 시간대 및 문자셋 설정
CMD ["mysqld", \
     "--character-set-server=utf8mb4", \
     "--collation-server=utf8mb4_unicode_ci", \
     "--default-time-zone=+09:00"]