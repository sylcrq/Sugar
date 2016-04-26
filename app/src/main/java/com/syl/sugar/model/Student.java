package com.syl.sugar.model;

import java.util.List;

/**
 * Created by shenyunlong on 16/4/26.
 */
public class Student {

    private String mName;
    private List<Course> mCourse;

    public Student(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public List<Course> getCourse() {
        return mCourse;
    }

    public void setCourse(List<Course> course) {
        this.mCourse = course;
    }
}
