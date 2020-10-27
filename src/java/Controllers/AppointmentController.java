package Controllers;

import Models.Appointment;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController {

    Connector con = Connector.getInstance();

    private AppointmentController() {
    }

    private static final AppointmentController obj = new AppointmentController();

    public static AppointmentController getInstance() {
        return obj;
    }

    public void Save(Appointment data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO appointment(patient_id,doctor_id,appointment_date,appointment_time,status,date_time) values ('" + data.getPatient_id() + "','" + data.getDoctor_id() + "','" + data.getAppointment_date() + "','" + data.getAppointment_time() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Appointment data) throws Exception {
        con.getConnection();
        con.aud("UPDATE appointment SET patient_id  = '" + data.getPatient_id() + "',doctor_id  = '" + data.getDoctor_id() + "',appointment_date  = '" + data.getAppointment_date() + "',appointment_time  = '" + data.getAppointment_time() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE appointment_id = '" + data.getAppointment_id() + "'");
    }

    public void Delete(Appointment data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM appointment WHERE appointment_id = '" + data.getAppointment_id() + "'");
    }

    public List<Appointment> SearchAll() throws Exception {
        List<Appointment> objList = new ArrayList<Appointment>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM appointment");
        while (rset.next()) {
            Appointment obj = new Appointment();
            obj.setAppointment_id(rset.getInt(1));
            obj.setPatient_id(rset.getInt(2));
            obj.setDoctor_id(rset.getInt(3));
            obj.setAppointment_date(rset.getString(4));
            obj.setAppointment_time(rset.getString(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Appointment> Search(Appointment data) throws Exception {
        List<Appointment> objList = new ArrayList<Appointment>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM appointment WHERE appointment_id = '" + data.getAppointment_id() + "'");
        while (rset.next()) {
            Appointment obj = new Appointment();
            obj.setAppointment_id(rset.getInt(1));
            obj.setPatient_id(rset.getInt(2));
            obj.setDoctor_id(rset.getInt(3));
            obj.setAppointment_date(rset.getString(4));
            obj.setAppointment_time(rset.getString(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
