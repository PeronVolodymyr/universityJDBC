package per.coursework.university.model;

public class Diploma {
    private int id;
    private String themeOfDiploma;
    private Teacher teacher;
    private Student student;

    public Diploma() {
    }

    public Diploma(int id, String themeOfDiploma, Teacher teacher, Student student) {
        this.id = id;
        this.themeOfDiploma = themeOfDiploma;
        this.teacher = teacher;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThemeOfDiploma() {
        return themeOfDiploma;
    }

    public void setThemeOfDiploma(String themeOfDiploma) {
        this.themeOfDiploma = themeOfDiploma;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
