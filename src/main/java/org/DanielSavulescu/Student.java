package org.DanielSavulescu;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * registers a course, adds the course to the student's registeredCourses list,
     * adds the student to the course's registeredStudents list
     * appends a null for the scores of each assignment of the course
     * if the course is already registered, nothing is added
     * @param course the course to be registered
     * @return true if the course has been registered, false if it has not/is already registered
     */
    public boolean registerCourse(Course course) {
        if (course == null || registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * drops a course, removes the course from the student's registeredCourses list,
     * removes the student from the course's registeredStudents list
     * if the course is not registered, nothing is removed
     * @param course the course to be dropped
     * @return true if the course has been dropped, false if it has not/is already dropped
     */
    public boolean dropCourse(Course course) {
        if (course == null || !registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    /**
     * converts a student to a simple string with only the studentId, the studentName, and departmentName
     * @return the simplifiedString
     */
    public String toSimplifiedString() {
        return studentId + " - " + studentName + " - " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String toStringStudent = "";
        toStringStudent += "Student ID: " + studentId + "\n";
        toStringStudent += "Name: " + studentName + "\n";
        toStringStudent += "Gender: " + gender + "\n";
        toStringStudent += "Address: " + address + "\n";
        toStringStudent += "Department: " + department.getDepartmentName() + "\n";

        if (registeredCourses.isEmpty()) {
            toStringStudent += "None";
        } else {
            for (Course course : registeredCourses) {
                toStringStudent += " " +
                course.getCourseId() + " - " +
                course.getCourseName() + " - " +
                course.getDepartment().getDepartmentName();
            }
        }

        return toStringStudent;
    }

    public enum Gender{
        FEMALE,
        MALE
    }
}
