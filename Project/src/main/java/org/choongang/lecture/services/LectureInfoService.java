package org.choongang.lecture.services;

import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.lecture.controllers.SearchLecture;
import org.choongang.lecture.entities.Lecture;
import org.choongang.lecture.mapper.LectureMapper;

import java.util.List;

public class LectureInfoService implements Service<Lecture>, Retrivable<SearchLecture, Lecture> {

    private final LectureMapper mapper;

    public LectureInfoService(LectureMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Lecture> getList(SearchLecture search) {
        return mapper.getList(search);
    }
}
