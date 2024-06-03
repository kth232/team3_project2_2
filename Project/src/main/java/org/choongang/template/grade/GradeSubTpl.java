package org.choongang.template.grade;

import org.choongang.template.Template;

public class GradeSubTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer();
        sb.append("<성적관리 서비스>");
        sb.append("1. 조회");
        sb.append("2. 수정");

        return sb.toString();
    }
}
