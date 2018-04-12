package per.coursework.university.model;

public class Department {
    private int id;
    private String name;
    private String dean;
    private Deanery deanery;

    public Department() {
    }

    public Department(int id, String name, String dean, Deanery deanery) {
        this.id = id;
        this.name = name;
        this.dean = dean;
        this.deanery = deanery;
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

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public Deanery getDeanery() {
        return deanery;
    }

    public void setDeanery(Deanery deanery) {
        this.deanery = deanery;
    }
}
