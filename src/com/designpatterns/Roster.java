package com.designpatterns;

import java.util.ArrayList;

public class Roster {
	private String courseName;
	private String courseNumber;
	private ArrayList<Student> students;
	
	public Roster(String name, String number) {
        this.courseName = name;
        this.courseNumber = number;
        students = new ArrayList<Student>();
    }
	
	public String getCourseName() {
        return courseName;
    }
	
	public void addStudent (Student student) {
        students.add(student);
    }
	
	AvgDispenser getDispenser(){
        return new OverrideRoster(students);
    }
}
