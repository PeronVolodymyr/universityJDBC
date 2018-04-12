package per.coursework.university.model;

public class Deanery {
    private int id;
    private String address;
    private String phoneNumber;

    public Deanery() {
    }

    public Deanery(int id, String address, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
