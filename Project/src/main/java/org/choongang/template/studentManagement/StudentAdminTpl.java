package org.choongang.template.studentManagement;

import org.choongang.template.Template;

public class StudentAdminTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("조회할 학생의 반을 선택하세요\n");
        sb.append("1. 502호💛\n");
        sb.append("2. 503호🧡\n");
        sb.append("3. 뒤로가기\n");
        return sb.toString();
    }
}
