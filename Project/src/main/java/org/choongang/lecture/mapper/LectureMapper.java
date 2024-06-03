package org.choongang.lecture.mapper;

import org.choongang.lecture.controllers.SearchLecture;
import org.choongang.lecture.entities.Lecture;

import java.util.List;

/* *
 * src/java/org/choongang/lecture/mapper/LectureMapper.java LectureMapper.xml과 동일한 패키지 경로, 동일 파일명으로 인터페이스를 만들면
 * LectureMapper에 정의한 select, insert, update, delete 태그의 id명으로 추상 메서드만 만들어도 서로 연결됨
 */
public interface LectureMapper {
    List<Lecture> getList(SearchLecture search);
    int register(Lecture lecture);
    int update(Lecture lecture);
}
