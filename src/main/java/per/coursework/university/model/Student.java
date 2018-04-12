package per.coursework.university.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private boolean children;
    private int scholarship;
    private Group group;

    public Student() {
    }

    public Student(int id, String name, LocalDate dateOfBirth, boolean children, int scholarship, Group group) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.children = children;
        this.scholarship = scholarship;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
