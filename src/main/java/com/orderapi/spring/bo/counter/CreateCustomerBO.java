package com.orderapi.spring.bo.counter;

public class CreateCustomerBO {
    private String name;
    private String email;
    private String phone;
    private String locality;
    private String dob;
    private String doa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    @Override
    public String toString() {
        return "CreateCustomerBO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", locality='" + locality + '\'' +
                ", dob='" + dob + '\'' +
                ", doa='" + doa + '\'' +
                '}';
    }
}
