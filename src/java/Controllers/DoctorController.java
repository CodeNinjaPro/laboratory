package Controllers;

import Models.Doctor;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {

    Connector con = Connector.getInstance();

    private DoctorController() {
    }

    private static final DoctorController obj = new DoctorController();

    public static DoctorController getInstance() {
        return obj;
    }

    public void Save(Doctor data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO doctor(name,specialization,available_days,available_time,email,contact,date_time) values ('" + data.getName() + "','" + data.getSpecialization() + "','" + data.getAvailable_days() + "','" + data.getAvailable_time() + "','" + data.getEmail() + "','" + data.getContact() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Doctor data) throws Exception {
        con.getConnection();
        con.aud("UPDATE doctor SET name  = '" + data.getName() + "',specialization  = '" + data.getSpecialization() + "',available_days  = '" + data.getAvailable_days() + "',available_time  = '" + data.getAvailable_time() + "',email  = '" + data.getEmail() + "',contact  = '" + data.getContact() + "',date_time  = '" + data.getDate_time() + "' WHERE doctor_id = '" + data.getDoctor_id() + "'");
    }

    public void Delete(Doctor data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM doctor WHERE doctor_id = '" + data.getDoctor_id() + "'");
    }

    public List<Doctor> SearchAll() throws Exception {
        List<Doctor> objList = new ArrayList<Doctor>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM doctor");
        while (rset.next()) {
            Doctor obj = new Doctor();
            obj.setDoctor_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setSpecialization(rset.getString(3));
            obj.setAvailable_days(rset.getString(4));
            obj.setAvailable_time(rset.getString(5));
            obj.setEmail(rset.getString(6));
            obj.setContact(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

    public List<Doctor> Search(Doctor data) throws Exception {
        List<Doctor> objList = new ArrayList<Doctor>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM doctor WHERE doctor_id = '" + data.getDoctor_id() + "'");
        while (rset.next()) {
            Doctor obj = new Doctor();
            obj.setDoctor_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setSpecialization(rset.getString(3));
            obj.setAvailable_days(rset.getString(4));
            obj.setAvailable_time(rset.getString(5));
            obj.setEmail(rset.getString(6));
            obj.setContact(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }
    
    //Testing---
    public void SaveTesting(Doctor data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO doctor(name,specialization,available_days,available_time,email,contact,date_time) values ('" + 1 + "','" + 1 + "','" + "Weekend" + "','" + "0800" + "','" + "kk@gmail.com" + "','" + "01145469874589" + "','" + "2020" + "') ");
    }
    
    public void SaveTestingFail(Doctor data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO doctor(name,specialization,available_days,available_time,email,contact,date_time) values ('" + 1 + "','" + "Weekend" + "','" + "0800" + "','" + "kk@gmail.com" + "','" + "01145469874589" + "','" + "2020" + "') ");
    }

}
