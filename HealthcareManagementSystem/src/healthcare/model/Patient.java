package healthcare.model;

public class Patient {
    private String id;
    private String name;
    private String email;
    private String nhs;
    private String address;
    private String phone;

    public Patient(String id, String name, String email, String nhs, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nhs = nhs;
        this.address = address;
        this.phone = phone;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getNhs() { return nhs; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setNhs(String nhs) { this.nhs = nhs; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return String.join(",", id, name, email, nhs, address, phone);
    }
}
