package per.coursework.university.model;

public class Group {
    private int id;
    private int course;
    private int number;
    private Chair chair;

    public Group() {
    }

    public Group(int id, int course, int number, Chair chair) {
        this.id = id;
        this.course = course;
        this.number = number;
        this.chair = chair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
