package com.person.personapi.model;

import java.time.LocalDate;

public class Person {
  private int id;
  private String fname;
  private String lname;
  private LocalDate dob;

  public Person() {
  }

  public Person(int id, String fname, String lname, LocalDate dob) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.dob = dob;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFname() {
    return this.fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return this.lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public LocalDate getDOB() {
    return dob;
  }

  public void setDOB(LocalDate dob) {
    this.dob = dob;
  }
}
