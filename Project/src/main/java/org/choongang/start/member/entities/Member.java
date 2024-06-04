package org.choongang.start.member.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Member { //데이터 베이스에서 조회한 레코드 담는 클래스 (회원가입정보 관련)
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String userJob; //직책
    private LocalDateTime regDt; //현재날짜
}
