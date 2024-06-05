package org.choongang.template.start;

import org.choongang.template.Template;

public class StartMainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("메뉴를 선택하세요.\n");
            sb.append("1. 회원가입\n");
            sb.append("2. 로그인\n");
        return sb.toString();
    }
}
