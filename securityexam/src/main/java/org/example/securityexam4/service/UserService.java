package org.example.securityexam4.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.securityexam4.repository.RoleRepository;
import org.example.securityexam4.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

//    회원가입 -- 반드시 비밀번호를 인코딩해서 입력해주세요!!!  권한!!


//    username에 해당하는 user가 있는지 체크하는 기능
}
