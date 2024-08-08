package com.example.prereqchecker.model;

import java.util.ArrayList;
import java.util.List;

public class CourseListNode {
  private String course;
  private List<String> prerequisites;

  public CourseListNode(String course) {
    this.course = course;
    prerequisites = new ArrayList<>();
  }

  public String getCourse() {
    return course;
  }

  public void addPrerequisite(String prereq) {
    prerequisites.add(prereq);
  }

  public List<String> getPrerequisites() {
    return prerequisites;
  }
}