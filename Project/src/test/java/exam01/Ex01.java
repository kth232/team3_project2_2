package exam01;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.start.member.entities.Member;
import org.choongang.start.member.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Ex01 {

    private SqlSession session = DBConn.getSession();

    @Test
    void Test1() {

        MemberMapper mapper = session.getMapper(MemberMapper.class);
        Member member = Member.builder()
                .userId("USER"+System.currentTimeMillis())
                .userPw("123456")
                .userNm("사용자이름1")
                .build();

//        int cnt = session.insert("org.choongang.start.member.mapper.MemberMapper.register",member);

        //insert test
        int cnt = mapper.register(member);

        //update test


        System.out.println(cnt);
    }

}
