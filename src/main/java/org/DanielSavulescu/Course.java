package org.DanielSavulescu;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;

    private static int nextId = 1;

    /**
     * checks if the sum of weights of all assignments of that course equals to 100%
     * @return true if the sum of weights of all assignments of that course equals to 100%, false if not
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0.0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == 100;
    }

    /**
     *  adds a student to the student list of the course,
     *  also adds a new null element to each assignment of this course,
     *  and adds a new `null` element for the
     * @param student the student
     * @return true if the student has been registered to this course, false if not
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * calculates the weighted average score of a student
     * @return the weighted average score of a student
     */
    public int[] calcStudentsAvg() {
        int[] avgs = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    sum += (score * assignment.getWeight()) / 100;
                }
            }

            avgs[i] = (int) sum;
        }

        return avgs;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the name of the assignment added
     * @param weight the weight of the assignment added
     * @return true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        assignments.add(assignment);

        return true;
    }

    /**
     * generates random scores for each assignment and student,
     * and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i); // null-safe check
                if (score != null) {
                    sum += (score * assignment.getWeight()) / 100.0;
                }
            }
        }
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ") ");
        System.out.println("\t\t");

        for (Assignment assignment : assignments) {
            System.out.println(assignment.getAssignmentName() + "\t");
        }

        System.out.println("Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.println(student.getStudentName() + "\t");

            for (Assignment assignment : assignments) {
                System.out.println(assignment.getScores().get(i) + "\t\t");
            }

            System.out.println();
        }

        System.out.println("Average\t\t");
        for (Assignment assignment : assignments) {
            System.out.println((int) assignment.calcAssignmentAvg() + "\t\t");
        }
        System.out.println();
    }

    /**
     * converts a course to a simple string with only the courseId, the courseName, the credits, and departmentName
     * @return the simplifiedString
     */
    public String toSimplifiedString() {
        return "Course ID: " + courseId +
                "Course Name: " + courseName +
                "Credits: " + credits +
                "Department Name: " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String toStringCourse = "";
        toStringCourse += "Course ID: " + courseId + "\n";
        toStringCourse += "Course Name: " + courseName + "\n";
        toStringCourse += "Credits: " + credits + "\n";
        toStringCourse += "Department: " + department.getDepartmentName()+ "\n";

        toStringCourse += "Assignments:\n";
        for (Assignment assignment : assignments) {
            toStringCourse += "  " + assignment + "\n";
        }

        toStringCourse += "Registered Students: \n";
        for (Student student : registeredStudents) {
            toStringCourse +=  " " +
                    "Student ID: " + student.getStudentId() + "\n" +
                    "Student Name: " + student.getStudentName() + "\n" +
                    "Department: " + student.getDepartment().getDepartmentName() + "\n";
        }

        toStringCourse += "Assignment Weight Valid" + isAssignmentWeightValid();
        return toStringCourse;
    }
}
