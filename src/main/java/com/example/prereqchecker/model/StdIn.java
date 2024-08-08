package com.example.prereqchecker.model;

import java.util.Scanner;

public class StdIn {
  private Scanner scanner;

  public StdIn() {
    scanner = new Scanner(System.in);
  }

  public boolean hasNext() {
    return scanner.hasNext();
  }

  public String readString() {
    return scanner.next();
  }
}
