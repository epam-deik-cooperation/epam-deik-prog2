package com.epam.training.student;

import com.epam.training.subject.Subject;
import java.util.Set;

public class Student {

    private String name;
    private Set<Subject> subjects;

    public String getName() {
        return name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

}
