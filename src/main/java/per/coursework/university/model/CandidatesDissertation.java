package per.coursework.university.model;

import java.time.LocalDate;

public class CandidatesDissertation {
    private int id;
    private String themeOfTheDissertation;
    private LocalDate protectionDate;
    private Teacher teacher;

    public CandidatesDissertation() {
    }

    public CandidatesDissertation(int id, String themeOfTheDissertation, LocalDate protectionDate, Teacher teacher) {
        this.id = id;
        this.themeOfTheDissertation = themeOfTheDissertation;
        this.protectionDate = protectionDate;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThemeOfTheDissertation() {
        return themeOfTheDissertation;
    }

    public void setThemeOfTheDissertation(String themeOfTheDissertation) {
        this.themeOfTheDissertation = themeOfTheDissertation;
    }

    public LocalDate getProtectionDate() {
        return protectionDate;
    }

    public void setProtectionDate(LocalDate protectionDate) {
        this.protectionDate = protectionDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
