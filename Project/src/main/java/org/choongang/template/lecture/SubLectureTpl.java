package org.choongang.template.lecture;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class SubLectureTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        
        sb.append("학급 관리\n");
        sb.append("선택한 반 이름 띄우기\n");
        sb.append("1. 학급 추가하기\n");
        sb.append("2. 학급 수정하기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
