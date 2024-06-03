package org.choongang.start.member.mapper;

import org.apache.ibatis.annotations.Param;
import org.choongang.start.member.entities.Member;

import java.util.List;

/*
* src/java/org/choongang/start/member/mapper/MemberMapper.java MemberMapper.xml과 동일한 패키지 경로, 동일 파일명으로 인터페이스를 만들면
* MemberMapper에 정의한 select, insert, update, delete 태그의 id명으로 추상 메서드만 만들어도 서로 연결이 된다.
* */
public interface MemberMapper {
    List<Member> getList(@Param("userId") String userId,
                         @Param("userNm") String userNm,
                         @Param("keyword") String keyword,
                         @Param("sRow") int sRow,
                         @Param("eRow") int eRow);
    Member get(String userId);
    int exist(String userId);
    int register(Member member);
    int modify(Member member);
    int delete(String userId);
}

