package per.coursework.university.model;

public class Chair {
    private int id;
    private String name;
    private String headOfChair;
    private Department department;

    public Chair() {
    }

    public Chair(int id, String name, String headOfChair, Department department) {
        this.id = id;
        this.name = name;
        this.headOfChair = headOfChair;
        this.department = department;
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

    public String getHeadOfChair() {
        return headOfChair;
    }

    public void setHeadOfChair(String headOfChair) {
        this.headOfChair = headOfChair;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
