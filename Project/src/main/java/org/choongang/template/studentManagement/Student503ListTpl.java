package org.choongang.template.studentManagement;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class Student503ListTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("💛503호 학생 정보입니다💛\n");
        sb.append("1. 학생 추가\n");
        sb.append("2. 학생 정보 수정\n");
        sb.append("3. 뒤로가기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
