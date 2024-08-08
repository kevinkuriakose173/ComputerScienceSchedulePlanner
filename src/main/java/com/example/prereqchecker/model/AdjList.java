package com.example.prereqchecker.model;

import java.util.*;

public class AdjList {
  public Map<String, CourseListNode> adjList;

  public AdjList() {
    adjList = new HashMap<>();
    initializeCourses();
  }

  public void initializeCourses() {
    // All CS Courses
    addCourse("CS111");
    addCourse("CS112");
    addCourse("CS205");
    addCourse("CS206");
    addCourse("CS211");
    addCourse("CS344");
    addCourse("CS210");
    addCourse("CS213");
    addCourse("CS214");
    addCourse("CS314");
    addCourse("CS323");
    addCourse("CS352");
    addCourse("CS411");
    addCourse("CS415");
    addCourse("CS416");
    addCourse("CS417");
    addCourse("CS437");
    addCourse("CS440");
    addCourse("MAT151");
    addCourse("MAT152");
    addCourse("MAT250");

    // adding prerequisites
    addEdge("CS112", "CS111");
    addEdge("CS112", "MAT151");
    addEdge("CS211", "CS112");
    addEdge("MAT152", "MAT151");
    addEdge("CS213", "CS112");
    addEdge("CS205", "CS111");
    addEdge("CS205", "MAT152");
    addEdge("CS210", "CS112");
    addEdge("CS214", "CS211");
    addEdge("MAT250", "MAT152");
    addEdge("CS206", "CS205");
    addEdge("CS336", "CS112");
    addEdge("CS336", "CS205");
    addEdge("CS344", "CS206");
    addEdge("CS344", "CS112");
    addEdge("CS439", "CS205");
    addEdge("CS314", "CS211");
    addEdge("CS314", "CS205");
    addEdge("CS323", "MAT250");
    addEdge("CS352", "CS206");
    addEdge("CS352", "CS211");
    addEdge("CS415", "CS211");
    addEdge("CS415", "CS314");
    addEdge("CS416", "CS214");
    addEdge("CS417", "CS416");
    addEdge("CS437", "CS336");
    addEdge("CS437", "CS214");
    addEdge("CS440", "CS205");
    addEdge("CS452", "CS344");
  }

  public void addCourse(String course) {
    adjList.putIfAbsent(course, new CourseListNode(course));
  }

  public void addEdge(String course, String prereq) {
    if (!adjList.containsKey(course)) {
      addCourse(course);
    }
    if (!adjList.containsKey(prereq)) {
      addCourse(prereq);
    }
    adjList.get(course).addPrerequisite(prereq);
  }

  public List<String> getPrerequisites(String course) {
    if (adjList.containsKey(course)) {
      return adjList.get(course).getPrerequisites();
    }
    return new ArrayList<>();
  }

  public boolean hasCourse(String course) {
    return adjList.containsKey(course);
  }

  public Set<String> getCourses() {
    return adjList.keySet();
  }
}
