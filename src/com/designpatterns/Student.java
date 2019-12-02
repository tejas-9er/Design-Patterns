package com.designpatterns;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements NfyGrade{
	private String name;
	private ArrayList<Double> assignment;
	private ArrayList<Double> exam;
	private ObvGrade observer;
	
	public Student(String name) {
		this.name = name;
        assignment = new ArrayList<Double>();
        exam = new ArrayList<Double>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addAssignmentScore (double as) {
		assignment.add(as);
	}
	
	public void addExamScore (double es) {
		exam.add(es);
	}
	
public double getAverage(boolean whichAlgorithm) {
		double sumas = 0.0;
		double sumes = 0.0;
		double average;
		if(!whichAlgorithm) {
			for(double mark : assignment) {
				sumas+=mark;
			}
			sumas = sumas/assignment.size();
			for(double mark : exam) {
				sumes+=mark;
			}
			sumes = sumes/exam.size();
			average = sumas * (0.4)+sumes * (0.6);
			return average;
		}
		else {
			if(assignment.size() > 1) {
				for(double mark : assignment) {
					sumas+=mark;
				}
				sumas -= Collections.min(assignment);
				sumas = sumas/(assignment.size()-1);
				for(double mark : exam) {
					sumes+=mark;
				}
				sumes = sumes/exam.size();
				average = (((0.4)*sumas)+((0.6)* sumes));
				return average;
			}
			else {
				getAverage(false);
			}
		}
		return 0.0;
	}

	@Override
	public void Notify(ObvGrade observer) {
		this.observer = observer;
	}

	@Override
	public void notifyObeserveGrade() {
		if(observer != null) {
			observer.update();
		}
	}
}
