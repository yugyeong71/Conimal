package com.example.api_conimal.user.controller;

import com.example.api_conimal.common.SuccessResponse;
import com.example.api_conimal.user.model.User;
import com.example.api_conimal.user.model.dto.SignUpForm;
import com.example.api_conimal.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController // 웹 서버 API -> Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/sign-up") // 회원가입
    @Transactional
    public SuccessResponse signUp(@RequestBody SignUpForm signUpForm){
        User user = User.builder()
                .nickName(signUpForm.getNickName())
                .fbUid(signUpForm.getFbUid())
                .petSlot(1)
                .point(0)
                .build();
        userRepository.save(user);

        SuccessResponse<User> successResponse = new SuccessResponse<User>("회원가입 성공");
        return successResponse;
    }

    @PostMapping("/login") // 로그인
    @Transactional
    public SuccessResponse login(@RequestBody SignUpForm signUpForm){
        User user = User.builder()
                .build();

        SuccessResponse<User> successResponse = new SuccessResponse<User>("로그인 성공");
        return successResponse;
    }

}
// 회원가입
// 사용자 : 아이디 입력 -> 비밀번호 입력 -> 닉네임 입력 -> 완료
// 서버 : 테이블에 저장 -> 응답
