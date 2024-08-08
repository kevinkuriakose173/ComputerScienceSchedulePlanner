package com.example.prereqchecker.model;

import java.util.*;

public class SchedulePlan {
  private AdjList graph;
  private Set<String> coursesTaken;

  public SchedulePlan() {
    graph = new AdjList();
    coursesTaken = new HashSet<>();
  }

  public void addCourse(String course) {
    if (graph.hasCourse(course)) {
      addCourseAndPrereqs(course);
    }
  }

  private void addCourseAndPrereqs(String course) {
    coursesTaken.add(course);
    for (String prereq : graph.getPrerequisites(course)) {
      if (!coursesTaken.contains(prereq)) {
        addCourseAndPrereqs(prereq);
      }
    }
  }

  public List<String> getCoursesTaken() {
    return new ArrayList<>(coursesTaken);
  }

  public List<String> getEligibleCourses() {
    Eligible eligible = new Eligible(graph, new ArrayList<>(coursesTaken));
    return eligible.getCourses();
  }

  public List<String> getNeedToTakeCourses(String course) {
    NeedToTake needToTake = new NeedToTake(graph, course, new ArrayList<>(coursesTaken));
    return needToTake.getCourses();
  }

}
