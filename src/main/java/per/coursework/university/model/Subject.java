package per.coursework.university.model;

public class Subject {
    private int id;
    private String name;
    private int numberOfHours;
    private TypeOfSubject typeOfSubject;
    private FormOfControl formOfControl;

    public Subject() {
    }

    public Subject(int id, String name, int numberOfHours, TypeOfSubject typeOfSubject, FormOfControl formOfControl) {
        this.id = id;
        this.name = name;
        this.numberOfHours = numberOfHours;
        this.typeOfSubject = typeOfSubject;
        this.formOfControl = formOfControl;
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

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public TypeOfSubject getTypeOfSubject() {
        return typeOfSubject;
    }

    public void setTypeOfSubject(TypeOfSubject typeOfSubject) {
        this.typeOfSubject = typeOfSubject;
    }

    public FormOfControl getFormOfControl() {
        return formOfControl;
    }

    public void setFormOfControl(FormOfControl formOfControl) {
        this.formOfControl = formOfControl;
    }
}
