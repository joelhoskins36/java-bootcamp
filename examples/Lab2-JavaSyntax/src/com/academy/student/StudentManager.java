package com.academy.student;

import java.util.Scanner;

public class StudentManager {

    private static final int MAX_STUDENTS = 20;

    private final Student[] students = new Student[MAX_STUDENTS];
    private int studentCount = 0;
    private final Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Student Management System");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Average Marks");
        System.out.println("5. Exit");
        System.out.print("Enter Choice : ");
    }
    public void addStudent(){
        int entry=1;
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student list is full.");
            return;
        }
        System.out.print("Student ID : ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Students Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the Students Course: ");
        String course = scanner.nextLine();
        if (name.trim().isEmpty()||course.trim().isEmpty()) {
            System.out.println("Name/Course cannot be empty.");
            return;
        }
        System.out.println("Enter the Students Marks: ");
        double marks = scanner.nextDouble();
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }
        students[studentCount] = new Student(studentId, name, course, marks);
        studentCount++;
    }
    public void displayStudents() {
        if(studentCount==0){
            System.out.println("No students to display");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];

            System.out.printf("%-8d %-20s %-15s %-8.2f%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getCourse(),
                    student.getMarks());
        }
    }

    public void searchStudent() {
        if(studentCount==0){
            System.out.println("No students to search%n");
            return;
        }
        System.out.println("Enter the students id:");
        int entryID = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            if(student.getStudentId()==entryID) {
                System.out.printf("%-8d %-20s %-15s %-8.2f%n",
                        student.getStudentId(),
                        student.getName(),
                        student.getCourse(),
                        student.getMarks());
                System.out.println("Student Found!%n");
                return;
            }

        }
        System.out.println("Student not found.%n");
    }

    public void calculateAverage() {
        double ans=0;
        if(studentCount==0){
            System.out.println("No students to average%n");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            ans=ans+student.getMarks();
        }
        System.out.println("The average marks is: " +(ans/studentCount));
    }
    // Methods addStudent, displayStudents, searchStudent, calculateAverage
    // will be filled in later steps.
}