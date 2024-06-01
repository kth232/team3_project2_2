package org.choongang.template.start;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StartMainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("메뉴를 선택하세요.\n");
            sb.append("1. 회원가입\n");
            sb.append("2. 로그인\n");
            sb.append(Templates.getInstance().line());
                //
        return sb.toString();
    }
}
