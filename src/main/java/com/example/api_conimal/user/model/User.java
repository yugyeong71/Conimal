package com.example.api_conimal.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id @GeneratedValue
    private Integer userId;

    private String nickName;

//    계좌비밀번호
    private String fbUid;

    private Integer point;

    @Column(columnDefinition = "TINYINT", length=4)
    private int petSlot;
}
