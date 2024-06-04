package org.choongang.template.admin;

import org.choongang.template.Template;

import java.util.function.Supplier;

public class ClassListTpl implements Template {

    private Supplier<String> hook;

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("반 목록\n");
        if (hook != null) {
            sb.append(hook.get());
        }
        
        return sb.toString();
    }

    @Override
    public void addHook(Supplier<String> hook) {
        this.hook = hook;
    }
}
