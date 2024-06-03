package org.choongang.template.admin;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StudentTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("======학생관리 시스템=======\n");
         sb.append("1. 반 선택\n");
         sb.append("2. 뒤로가기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
