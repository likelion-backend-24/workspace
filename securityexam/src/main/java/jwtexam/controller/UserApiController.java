package jwtexam.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jwtexam.domain.RefreshToken;
import jwtexam.domain.Role;
import jwtexam.domain.User;
import jwtexam.dto.UserLoginResponeDto;
import jwtexam.jwt.util.JwtTokenizer;
import jwtexam.security.dto.UserLoginDto;
import jwtexam.service.RefreshTokenService;
import jwtexam.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDto userLoginDto,
                                   BindingResult bindingResult,
                                   HttpServletResponse response){
//        jwt를 이용해서 로그인할때 사용자(클라이언트)는 어떤 정보들을 보내줄까요??
//1. 사용자가 입력한 값이 유효한가?
        if(bindingResult.hasErrors()){
            //유효성검증 실패.  이랬을때는 오류메시지 바디에 담아 넘겨줘요.
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

//        2. 사용자가 입력한 정보가 시스템이 가진 정보와 동일 한가??  username 으로 user 존재하나?
        User user = userService.findByUsername(userLoginDto.getUsername()).orElse(null);
        if(user == null || !passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())){
            // user가 존재하지 않거나,  비밀번호가 일치하지 않는다면 401 반환!!
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디나 비밀번호가 올바르지 않습니다.");
        }

        //3. 토큰 발급
        //3-1. 토큰 발급을 위해 Role 정보 추출
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        //3-2. 각각 토큰 발급 
        String accessToken = jwtTokenizer.createAccessToken(user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);
        String refreshToken = jwtTokenizer.createRefreshToken(user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);

//        4. 리프레시토큰 DB저장
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setToken(refreshToken);
        refreshTokenEntity.setUserId(user.getId());

        refreshTokenService.addRefreshToken(refreshTokenEntity);

//        토큰을 쿠키에 구워보내든지, 응답에 실어 보내든지..
        addTokenCookie("acessToken", accessToken, jwtTokenizer.getAccessTokenExpireCount(), response);
        addTokenCookie("refreshToken", refreshToken, jwtTokenizer.getRefreshTokenExpireCount(), response);

        //응답에 accessToken, refreshToken, userId, userName

        UserLoginResponeDto responeDto = UserLoginResponeDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .name(user.getName())
                .build();


        return ResponseEntity.ok(responeDto);
    }

    private void addTokenCookie(String cookieName, String cookieValue, Long expireCount, HttpServletResponse response){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        cookie.setHttpOnly(true);  //자바스크립트는 이 쿠키에 접근 불가능!!
        cookie.setMaxAge(Math.toIntExact(expireCount/1000));
//        cookie.setSecure(true);  //htts를 사용한다면..  필요함!!
        response.addCookie(cookie);
    }

}
