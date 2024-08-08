package com.example.prereqchecker.service;

import com.example.prereqchecker.model.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrereqCheckerService {
  private final SchedulePlan schedulePlan;

  public PrereqCheckerService() {
    this.schedulePlan = new SchedulePlan();
  }

  public void addCourse(String course) {
    schedulePlan.addCourse(course);
  }

  public List<String> getCoursesTaken() {
    return schedulePlan.getCoursesTaken();
  }

  public List<String> getEligibleCourses() {
    return schedulePlan.getEligibleCourses();
  }

  public List<String> getNeedToTakeCourses(String course) {
    return schedulePlan.getNeedToTakeCourses(course);
  }

}
