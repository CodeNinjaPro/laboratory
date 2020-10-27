package Models;

public class Doctor {

    private int doctor_id;
    private String name;
    private String specialization;
    private String available_days;
    private String available_time;
    private String email;
    private String contact;
    private String date_time;

    public Doctor() {
    }

    public Doctor(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Doctor(int doctor_id, String name, String specialization, String available_days, String available_time, String email, String contact, String date_time) {
        this.doctor_id = doctor_id;
        this.name = name;
        this.specialization = specialization;
        this.available_days = available_days;
        this.available_time = available_time;
        this.email = email;
        this.contact = contact;
        this.date_time = date_time;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailable_days() {
        return available_days;
    }

    public void setAvailable_days(String available_days) {
        this.available_days = available_days;
    }

    public String getAvailable_time() {
        return available_time;
    }

    public void setAvailable_time(String available_time) {
        this.available_time = available_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
