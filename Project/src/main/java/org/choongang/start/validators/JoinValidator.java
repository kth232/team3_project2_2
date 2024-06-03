package org.choongang.start.validators;

import org.choongang.start.controllers.InputJoin;
import org.choongang.start.member.mapper.MemberMapper;
import org.choongang.start.validators.exceptions.ValidationException;

public class JoinValidator implements Validator<InputJoin>, RequiredValidator{

    private final MemberMapper mapper;

    public JoinValidator(MemberMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void check(InputJoin form) {
        // 필수 항목 체크 S
        String userName = form.getUserName();
        String userId = form.getUserId();
        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();
        String userJob = form.getUserJob();

        checkRequired(userName, new ValidationException("이름을 입력하세요."));
        checkRequired(userId, new ValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new ValidationException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new ValidationException("비밀번호 확인을 입력하세요."));
        checkRequired(userJob, new ValidationException("직책을 입력하세요."));
        // 필수 항목 체크 E

        //이름 두자리 이상, 한글 입력
        if(userName == null || userName.length() < 2 || !userName.matches("[가-힣]{2,}")){

            throw new ValidationException("이름은 두자리 이상 한글로 입력하세요.");

        }

        // 아이디 자리수 체크(6자리 이상)
        if (userId == null || userId.length() < 6) {
            throw new ValidationException("아이디는 6자리 이상 입력하세요.");
        }

        // 아이디 중복 여부 체크
        if (mapper.exist(userId) > 0) {
            throw new ValidationException("이미 등록된 아이디 입니다.");
        }

        // 비밀번호 자리수 체크(8자리 이상)
        if (userPw == null || userPw.length() < 8) {
            throw new ValidationException("비밀번호는 8자리 이상 입력하세요.");
        }

        // 비밀번호, 비밀번호 확인 일치 여부 체크
        if (userPw != null && confirmPw != null && !userPw.equals(confirmPw)) {
            throw new ValidationException("비밀번호가 일치하지 않습니다.");
        }

        //올바른 직책 입력 여부 체크
        if(!userJob.equals("강사") && !userJob.equals("매니저")){
            throw new ValidationException("직책은 강사 또는 매니저 중 입력해주세요.");
        }

    }
}
