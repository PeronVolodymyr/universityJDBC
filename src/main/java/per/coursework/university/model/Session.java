package per.coursework.university.model;

public class Session {
    private int id;
    private int mark;
    private Student student;
    private Curriculum curriculum;

    public Session() {
    }

    public Session(int id, int mark, Student student, Curriculum curriculum) {
        this.id = id;
        this.mark = mark;
        this.student = student;
        this.curriculum = curriculum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
}
