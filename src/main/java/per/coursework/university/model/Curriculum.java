package per.coursework.university.model;

public class Curriculum {
    private int id;
    private int semester;
    private Teacher teacher;
    private Subject subject;
    private Group group;

    public Curriculum() {
    }

    public Curriculum(int id, int semester, Teacher teacher, Subject subject, Group group) {
        this.id = id;
        this.semester = semester;
        this.teacher = teacher;
        this.subject = subject;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
