package org.choongang.start.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputLogin { //사용자가 입력한 로그인 데이터 전달용 클래스
    private String userId;
    private String userPw;
}
