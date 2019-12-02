package com.designpatterns;

public class GradeTracker implements ObvGrade{

    Student stud;
    double averageScore;
    GradeTracker(Student student){
        this.stud = student;
        averageScore = getStudentAverage();
    }

    public Character getLetterGrade(){
        if(averageScore >= 90){
            return 'A';
        }
        else if(averageScore >=80){
            return 'B';
        }
        else if(averageScore >= 70){
            return 'C';
        }
        else {
            return 'F';
        }
    }

    @Override
    public void update() {
        averageScore = getStudentAverage();
    }

    private double getStudentAverage(){
        return this.stud.getAverage(false);
    }
}