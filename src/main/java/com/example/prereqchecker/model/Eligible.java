package com.example.prereqchecker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Eligible {
  private AdjList graph;
  private Set<String> coursesTaken;
  private List<String> eligibleCourses;

  public Eligible(AdjList graph, List<String> coursesTaken) {
    this.graph = graph;
    this.coursesTaken = new HashSet<>(coursesTaken);
    eligibleCourses = new ArrayList<>();
    findEligibleCourses();
  }

  private void findEligibleCourses() {
    for (String course : graph.getCourses()) {
      if (isEligible(course) && !coursesTaken.contains(course)) {
        eligibleCourses.add(course);
      }
    }
  }

  private boolean isEligible(String course) {
    for (String prereq : graph.getPrerequisites(course)) {
      if (!coursesTaken.contains(prereq)) {
        return false;
      }
    }
    return true;
  }

  public List<String> getCourses() {
    return eligibleCourses;
  }
}
