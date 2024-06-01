package org.choongang.template.admin;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class AttendanceTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("각자 추가해주세요.\n");
       // sb.append("1. 반 선택\n");
       // sb.append("2. 뒤로가기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
