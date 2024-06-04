package org.choongang.template.studentManagement;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StudentModTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        // 수정사항
        sb.append("❤학생 정보 수정 페이지❤\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
