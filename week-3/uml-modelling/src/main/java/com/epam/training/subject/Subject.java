package com.epam.training.subject;

import com.epam.training.lecturer.Lecturer;
import com.epam.training.student.Student;
import java.util.Set;

public class Subject {

    private String code;
    private String name;
    private SubjectType subjectType;
    private Set<Student> students;
    private Set<Lecturer> lecturers;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void addNewStudent(Student student) {
        this.students.add(student);
    }

    public void addNewLecturer(Lecturer lecturer) {
        this.lecturers.add(lecturer);
    }

}
