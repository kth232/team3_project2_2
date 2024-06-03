package org.choongang.start.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputJoin { //사용자가 입력한 회원가입 정보 전달용 클래스
    private String userName;
    private String userId;
    private String userPw;
    private String userJob;
    private String confirmPw;
}
