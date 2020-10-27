package Models;

public class Report {

    private int report_id;
    private int patient_id;
    private String type;
    private String category;
    private String description;
    private String status;
    private String date_time;

    public Report() {
    }

    public Report(int report_id) {
        this.report_id = report_id;
    }

    public Report(int report_id, int patient_id, String type, String category, String description, String status, String date_time) {
        this.report_id = report_id;
        this.patient_id = patient_id;
        this.type = type;
        this.category = category;
        this.description = description;
        this.status = status;
        this.date_time = date_time;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
