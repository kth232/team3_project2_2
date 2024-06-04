package org.choongang.start.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.start.controllers.InputJoin;
import org.choongang.start.member.entities.Member;
import org.choongang.start.member.mapper.MemberMapper;
import org.choongang.start.validators.JoinValidator;
import org.choongang.start.validators.exceptions.ValidationException;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

@RequiredArgsConstructor
public class JoinService implements Service<InputJoin> {
    //사용자가 보낸(사용자에게 입력받은) 회원가입 데이터 처리하는 클래스

    private final MemberMapper mapper;
    private final JoinValidator validator;
    @Override
    public void process(InputJoin form) {

        //회원가입 유효성 검사
        validator.check(form);
        //비밀번호 해시화
        String userPw = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(10));

        // 데이터베이스에 영구 저장
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(userPw)
                .userNm(form.getUserName())
                .userJob(form.getUserJob())
                .build();
        int affectedRows = mapper.register(member);

        if (affectedRows < 1) { // 회원 가입 처리 실패시
            throw new ValidationException("회원가입 실패하였습니다.");
        }


    } //회원가입 기능
}
