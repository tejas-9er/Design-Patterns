package com.designpatterns;

import java.text.DecimalFormat;
//import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		Student student = new Student("Tejas Gandre");
        student.addAssignmentScore(99.0);
        student.addAssignmentScore(105.0);
        student.addAssignmentScore(92.7);
        student.addExamScore(100);
        student.addExamScore(93.2);
        
        //Q1 Average Calculator
        //Algorithm A
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(student.getName() + "  " + df.format(student.getAverage(false)));
        
        //Algorithm B
        System.out.println(student.getName() + "  " + df.format(student.getAverage(true)));
        
        //Algorithm A
        System.out.println(student.getName() + "  " + df.format(student.getAverage(false)));
        
        //Q2 Testing Grade Tracker
        GradeTracker gt = new GradeTracker(student);
        student.Notify(gt);
        System.out.println("letter grade: " + gt.getLetterGrade());
        student.addExamScore(93.8);
        System.out.println("Added an exam score.");
        System.out.println("letter grade: " + gt.getLetterGrade());
        
        //Q3 
        Student sp = new Student("Siddhant Padve");
        sp.addAssignmentScore(96.2);
        sp.addAssignmentScore(98.1);
        sp.addAssignmentScore(99.3);
        sp.addExamScore(95);
        sp.addExamScore(97);
        
        //new Roster
        Roster autonomicComputing = new Roster("Autonomic Computing","MAG2308");
        autonomicComputing.addStudent(student);
        autonomicComputing.addStudent(sp);
        
        //test the Roster traversal
        System.out.println("Autonomic Computing Grades grades:");
        AvgDispenser ad = autonomicComputing.getDispenser();
        while (ad.nextAvailable()) {
            System.out.println("next average " + df.format(ad.getNextAvg()));
        }
	}
}
