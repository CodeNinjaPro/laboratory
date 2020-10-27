package Controllers;

import Models.Patient;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientController {

    Connector con = Connector.getInstance();

    private PatientController() {
    }

    private static final PatientController obj = new PatientController();

    public static PatientController getInstance() {
        return obj;
    }

    public void Save(Patient data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO patient(name,address,dob,nic,contact,email,username,password,date_time) values ('" + data.getName() + "','" + data.getAddress() + "','" + data.getDob() + "','" + data.getNic() + "','" + data.getContact() + "','" + data.getEmail() + "','" + data.getUsername() + "','" + data.getPassword() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Patient data) throws Exception {
        con.getConnection();
        con.aud("UPDATE patient SET name  = '" + data.getName() + "',address  = '" + data.getAddress() + "',dob  = '" + data.getDob() + "',nic  = '" + data.getNic() + "',contact  = '" + data.getContact() + "',email  = '" + data.getEmail() + "',username  = '" + data.getUsername() + "',password  = '" + data.getPassword() + "',date_time  = '" + data.getDate_time() + "' WHERE patient_id = '" + data.getPatient_id() + "'");
    }

    public void Delete(Patient data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM patient WHERE patient_id = '" + data.getPatient_id() + "'");
    }

    public List<Patient> SearchAll() throws Exception {
        List<Patient> objList = new ArrayList<Patient>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM patient");
        while (rset.next()) {
            Patient obj = new Patient();
            obj.setPatient_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setDob(rset.getString(4));
            obj.setNic(rset.getString(5));
            obj.setContact(rset.getString(6));
            obj.setEmail(rset.getString(7));
            obj.setUsername(rset.getString(8));
            obj.setPassword(rset.getString(9));
            obj.setDate_time(rset.getString(10));
            objList.add(obj);
        }

        return objList;
    }

    public Patient Search(int id) throws Exception {
        Patient obj = new Patient();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM patient WHERE patient_id = '" + id + "'");
        while (rset.next()) {
            obj.setPatient_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setDob(rset.getString(4));
            obj.setNic(rset.getString(5));
            obj.setContact(rset.getString(6));
            obj.setEmail(rset.getString(7));
            obj.setUsername(rset.getString(8));
            obj.setPassword(rset.getString(9));
            obj.setDate_time(rset.getString(10));
        }

        return obj;
    }
    
    //Testing
    public void SaveTesting(Patient data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO patient(name,address,dob,nic,contact,email,username,password,date_time) values ('" + "kk" + "','" + "dd" + "','" + "1994" + "','" + "888v" + "','" + "011254" + "','" + "a@gmail.com" + "','" + "sdfdf" + "','" + "dsfsdf" + "','" + "iiio" + "') ");
    }
    
    public void SaveTestingFail(Patient data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO patient(name,address,dob,nic,contact,email,username,password,date_time) values ('" + "dd" + "','" + "1994" + "','" + "888v" + "','" + "011254" + "','" + "a@gmail.com" + "','" + "sdfdf" + "','" + "dsfsdf" + "','" + "iiio" + "') ");
    }

}
