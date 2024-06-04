package org.choongang.template.start;

import org.choongang.template.Template;
import org.choongang.template.Templates;
import org.choongang.template.admin.AttendanceTpl;

import java.util.Scanner;

public class AttendanceTpl2 implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("1. 502호 선택\n");
        sb.append("2. 503호 선택\n");
        sb.append("3. 뒤로가기\n");

        sb.append(Templates.getInstance().line());

        return sb.toString();
    }

    public static void main(String[] args) {
        AttendanceTpl tpl = new AttendanceTpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(tpl.getTpl());
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("502호 선택됨");
                // 502호에 대한 추가 로직을 여기에 추가
            } else if (choice == 2) {
                System.out.println("503호 선택됨");
                // 503호에 대한 추가 로직을 여기에 추가
            } else if (choice == 3) {
                System.out.println("뒤로가기 선택됨");
                break; // 반복문 종료
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }

        scanner.close();
    }
}





