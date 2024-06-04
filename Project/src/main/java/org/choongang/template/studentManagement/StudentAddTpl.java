package org.choongang.template.studentManagement;

import org.choongang.template.Template;

public class StudentAddTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        // 추가사항
        sb.append("❤학생 정보 추가 페이지❤\n");

        return sb.toString();
    }
}
