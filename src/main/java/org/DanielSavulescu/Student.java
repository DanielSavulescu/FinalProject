package org.DanielSavulescu;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    /**
     * registers a course, adds the course to the student's registeredCourses list, adds the student to the course's registeredStudents list
     * appends a null for the scores of each assignment of the course
     * if the course is already registered, nothing is added
     * @param course the course to be registered
     * @return true if the course has been registered, false if it has not/is already registered
     */
    public boolean registerCourse(Course course) {
        if (course == null || registeredCourses.contains(course)) {
            return false;
        }



        return true;
    }

    public enum Gender{
        FEMALE,
        MALE
    }
}
