package com.example.prereqchecker.controller;

import com.example.prereqchecker.service.PrereqCheckerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PrereqCheckerController {

  @Autowired
  private PrereqCheckerService prereqCheckerService;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/addCourse")
  public String addCourseForm(Model model) {
    model.addAttribute("coursesTaken", prereqCheckerService.getCoursesTaken());
    return "addCourse";
  }

  @PostMapping("/addCourse")
  public String addCourse(@RequestParam String course, Model model) {
    prereqCheckerService.addCourse(course);
    model.addAttribute("message", "Course added successfully!");
    model.addAttribute("coursesTaken", prereqCheckerService.getCoursesTaken());
    return "addCourse";
  }

  @GetMapping("/checkEligibleCourses")
  public String checkEligibleCourses(Model model) {
    model.addAttribute("eligibleCourses", prereqCheckerService.getEligibleCourses());
    return "checkEligibleCourses";
  }

  @GetMapping("/checkNeededCourses")
  public String checkNeededCoursesForm() {
    return "checkNeededCourses";
  }

  @PostMapping("/checkNeededCourses")
  public String checkNeededCourses(@RequestParam String course, Model model) {
    List<String> neededCourses = prereqCheckerService.getNeedToTakeCourses(course);
    model.addAttribute("neededCourses", neededCourses);
    return "checkNeededCourses";
  }

}
