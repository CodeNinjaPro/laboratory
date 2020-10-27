package Models;

public class Payment {

    private int payment_id;
    private int appointment_id;
    private double amount;
    private String date_time;

    public Payment() {
    }

    public Payment(int payment_id) {
        this.payment_id = payment_id;
    }

    public Payment(int payment_id, int appointment_id, double amount, String date_time) {
        this.payment_id = payment_id;
        this.appointment_id = appointment_id;
        this.amount = amount;
        this.date_time = date_time;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
