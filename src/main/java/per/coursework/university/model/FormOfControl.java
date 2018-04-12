package per.coursework.university.model;

public class FormOfControl {
    private int id;
    private String form;

    public FormOfControl() {
    }

    public FormOfControl(int id, String form) {
        this.id = id;
        this.form = form;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
