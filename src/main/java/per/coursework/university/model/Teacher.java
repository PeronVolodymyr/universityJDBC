package per.coursework.university.model;

import java.time.LocalDate;

public class Teacher {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private int countOfChildren;
    private int salary;
    private CategoryOfTeacher categoryOfTeacher;
    private Chair chair;

    public Teacher() {
    }

    public Teacher(int id, String name, LocalDate dateOfBirth, int countOfChildren, int salary, CategoryOfTeacher categoryOfTeacher, Chair chair) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countOfChildren = countOfChildren;
        this.salary = salary;
        this.categoryOfTeacher = categoryOfTeacher;
        this.chair = chair;
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

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public CategoryOfTeacher getCategoryOfTeacher() {
        return categoryOfTeacher;
    }

    public void setCategoryOfTeacher(CategoryOfTeacher categoryOfTeacher) {
        this.categoryOfTeacher = categoryOfTeacher;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
