package com.example.api_conimal.user.model.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class SignUpForm {

    private String nickName;

    private String fbUid;

    private Integer userId;

    public String getNickName(){
        return nickName;
    }

    public String getFbUid(){
        return fbUid;
    }

    public Integer getUserId(){
        return userId;
    }

}
