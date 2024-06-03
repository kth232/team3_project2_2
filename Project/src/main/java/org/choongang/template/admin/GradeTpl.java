package org.choongang.template.admin;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class GradeTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("<성적관리>\n");
        sb.append("메뉴를 선택하세요.\n");
        sb.append("1. 반별 성적관리\n");
        sb.append("2. 뒤로가기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
