package org.choongang.template.lecture;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class ChoiceLectureTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("학급 리스트 띄우기\n");
        sb.append("학급을 선택하세요.\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
