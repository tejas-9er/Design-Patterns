package com.designpatterns;

import java.util.ArrayList;

public class OverrideRoster implements AvgDispenser {
	
	private int counter = 0;
    private ArrayList<Student> studs;

	public OverrideRoster(ArrayList<Student> students) {
		studs = students;
	}

	@Override
	public double getNextAvg() {
		return studs.get(counter++).getAverage(false);
	}

	@Override
	public boolean nextAvailable() {
		return counter < studs.size();
	}

}
