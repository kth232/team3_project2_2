package org.choongang.template.admin;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class LectureTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("학급 관리\n");
        sb.append("1. 반 선택하기\n");
        sb.append("2. 뒤로 가기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
