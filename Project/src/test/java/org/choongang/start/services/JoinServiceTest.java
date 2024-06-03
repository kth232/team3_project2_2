package org.choongang.start.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.controllers.InputJoin;
import org.choongang.start.member.mapper.MemberMapper;
import org.choongang.start.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JoinServiceTest {
    private Service<InputJoin> service;
    private InputJoin form;
    private MemberMapper memberMapper;
    private JoinValidator validator;

    @BeforeEach
    void init() {
        form = InputJoin.builder()
                .userName("김중앙")
                .userId("u" + System.currentTimeMillis())
                .userPw("12345678")
                .confirmPw("12345678")
                .userJob("강사")
                .build();

        // DBConn을 통해 SqlSession 생성
        try (SqlSession sqlSession = DBConn.getSession()) {
            memberMapper = sqlSession.getMapper(MemberMapper.class);
            validator = new JoinValidator(memberMapper);
            service = new JoinService(memberMapper, validator);
        }
    }

    @Test
    @DisplayName("회원 가입시 예외 발생이 없고, 추가한 회원으로 조회가 되면 성공")
    void registerSuccessTest() {
        assertDoesNotThrow(() -> {
            try (SqlSession sqlSession = DBConn.getSession()) {
                memberMapper = sqlSession.getMapper(MemberMapper.class);
                validator = new JoinValidator(memberMapper);
                service = new JoinService(memberMapper, validator);
                service.process(form);
                sqlSession.commit();
            }
        });
    }
}
