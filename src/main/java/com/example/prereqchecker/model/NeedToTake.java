package com.example.prereqchecker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NeedToTake {
  private AdjList graph;
  private String course;
  private Set<String> coursesTaken;
  private List<String> needToTakeCourses;

  public NeedToTake(AdjList graph, String course, List<String> coursesTaken) {
    this.graph = graph;
    this.course = course;
    this.coursesTaken = new HashSet<>(coursesTaken);
    needToTakeCourses = new ArrayList<>();
    findNeedToTakeCourses();
  }

  private void findNeedToTakeCourses() {
    findNeedToTakeCourses(course);
  }

  private void findNeedToTakeCourses(String course) {
    for (String prereq : graph.getPrerequisites(course)) {
      if (!coursesTaken.contains(prereq)) {
        findNeedToTakeCourses(prereq);
        needToTakeCourses.add(prereq);
      }
    }
  }

  public List<String> getCourses() {
    return needToTakeCourses;
  }
}
