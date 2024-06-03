package org.choongang.attendance.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchAttendance {
    private String Name;
    private String classNm;

}
