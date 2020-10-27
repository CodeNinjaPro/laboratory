package Controllers;

import Models.Report;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportController {

    Connector con = Connector.getInstance();

    private ReportController() {
    }

    private static final ReportController obj = new ReportController();

    public static ReportController getInstance() {
        return obj;
    }

    public void Save(Report data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO report(patient_id,type,category,description,status,date_time) values ('" + data.getPatient_id() + "','" + data.getType() + "','" + data.getCategory() + "','" + data.getDescription() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Report data) throws Exception {
        con.getConnection();
        con.aud("UPDATE report SET patient_id  = '" + data.getPatient_id() + "',type  = '" + data.getType() + "',category  = '" + data.getCategory() + "',description  = '" + data.getDescription() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE report_id = '" + data.getReport_id() + "'");
    }

    public void Delete(Report data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM report WHERE report_id = '" + data.getReport_id() + "'");
    }

    public List<Report> SearchAll() throws Exception {
        List<Report> objList = new ArrayList<Report>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM report");
        while (rset.next()) {
            Report obj = new Report();
            obj.setReport_id(rset.getInt(1));
            obj.setPatient_id(rset.getInt(2));
            obj.setType(rset.getString(3));
            obj.setCategory(rset.getString(4));
            obj.setDescription(rset.getString(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public Report Search(int id) throws Exception {
        Report obj = new Report();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM report WHERE report_id = '" + id + "'");
        while (rset.next()) {
            obj.setReport_id(rset.getInt(1));
            obj.setPatient_id(rset.getInt(2));
            obj.setType(rset.getString(3));
            obj.setCategory(rset.getString(4));
            obj.setDescription(rset.getString(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
        }

        return obj;
    }
    
    //Testing
    
    public void SaveTesting(Report data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO report(patient_id,type,category,description,status,date_time) values ('" + 1 + "','" + "tye" + "','" + "dsfs" + "','" + "dsfds" + "','" + "sdfsdf" + "','" + "2020" + "') ");
    }
    
    public void SaveTestingFail(Report data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO report(patient_id,type,category,description,status,date_time) values ('" + "tye" + "','" + "dsfs" + "','" + "dsfds" + "','" + "sdfsdf" + "','" + "2020" + "') ");
    }

}
