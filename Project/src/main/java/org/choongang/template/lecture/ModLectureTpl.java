package org.choongang.template.lecture;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class ModLectureTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        
        sb.append("학급 수정\n");
        sb.append("선택한 반 이름 띄우기, 학급 리스트 띄우기\n");
        sb.append("수정할 학급 정보를 입력하세요.\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
