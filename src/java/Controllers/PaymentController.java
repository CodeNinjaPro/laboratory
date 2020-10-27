package Controllers;

import Models.Payment;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {

    Connector con = Connector.getInstance();

    private PaymentController() {
    }

    private static final PaymentController obj = new PaymentController();

    public static PaymentController getInstance() {
        return obj;
    }

    public void Save(Payment data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO payment(appointment_id,amount,date_time) values ('" + data.getAppointment_id() + "','" + data.getAmount() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Payment data) throws Exception {
        con.getConnection();
        con.aud("UPDATE payment SET appointment_id  = '" + data.getAppointment_id() + "',amount  = '" + data.getAmount() + "',date_time  = '" + data.getDate_time() + "' WHERE payment_id = '" + data.getPayment_id() + "'");
    }

    public void Delete(Payment data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM payment WHERE payment_id = '" + data.getPayment_id() + "'");
    }

    public List<Payment> SearchAll() throws Exception {
        List<Payment> objList = new ArrayList<Payment>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM payment");
        while (rset.next()) {
            Payment obj = new Payment();
            obj.setPayment_id(rset.getInt(1));
            obj.setAppointment_id(rset.getInt(2));
            obj.setAmount(rset.getDouble(3));
            obj.setDate_time(rset.getString(4));
            objList.add(obj);
        }

        return objList;
    }

    public Payment Search(int id) throws Exception {
        Payment obj = new Payment();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM payment WHERE payment_id = '" + id + "'");
        while (rset.next()) {
            obj.setPayment_id(rset.getInt(1));
            obj.setAppointment_id(rset.getInt(2));
            obj.setAmount(rset.getDouble(3));
            obj.setDate_time(rset.getString(4));
        }

        return obj;
    }

    public int getLastID() throws Exception {
        int id = 0;
        con.getConnection();
        ResultSet rset = con.srh("SELECT MAX(payment_id) FROM payment");
        if (rset.next()) {
            id = rset.getInt(1);
        }

        return id;
    }
    
    //Testing
    public void SaveTesting(Payment data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO payment(appointment_id,amount,date_time) values ('" + 1 + "','" + 5020 + "','" + "2020" + "') ");
    }
    public void SaveTestingFail(Payment data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO payment(appointment_id,amount,date_time) values ('" + 5020 + "','" + "2020" + "') ");
    }

}
