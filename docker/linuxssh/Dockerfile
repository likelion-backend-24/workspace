FROM amazonlinux:2023

# 1) 패키지 업데이트 & SSH 서버 설치 (passwd도 같이 설치해두면 유용)
RUN yum update -y && \
    yum install -y openssh-server passwd

# 2) root 암호 설정(테스트용)
RUN echo 'root:rootpass' | chpasswd

# 3) SSH 관련 디렉토리 생성 (이미 존재할 수도 있지만, 혹시 몰라서 생성)
RUN mkdir -p /var/run/sshd

# 4) SSH 호스트키 생성 (필수! 이게 없으면 "no hostkeys available" 오류 발생)
RUN ssh-keygen -A

# 5) 비밀번호 로그인을 허용하려면 sshd_config 수정 (필요 시)
RUN sed -i 's/^#PasswordAuthentication.*/PasswordAuthentication yes/' /etc/ssh/sshd_config && \
    sed -i 's/^PasswordAuthentication no/PasswordAuthentication yes/' /etc/ssh/sshd_config && \
    sed -i 's/^#PermitRootLogin.*/PermitRootLogin yes/' /etc/ssh/sshd_config && \
    sed -i 's/^PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# 6) 필요 패키지 설치 (예: git, which 등)
RUN yum install -y git which

# 7) SSH 데몬 포그라운드 실행
CMD ["/usr/sbin/sshd", "-D", "-e"]