package org.choongang.template.admin;

import org.choongang.template.Template;

public class AdminMainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("메뉴를 선택하세요.\n");
        sb.append("1. 학생관리\n");
        sb.append("2. 출결관리\n");
        sb.append("3. 성적관리\n");
        sb.append("4. 수업관리\n");
        return sb.toString();
    }
}
