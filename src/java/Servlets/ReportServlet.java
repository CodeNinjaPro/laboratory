package Servlets;

import Controllers.PatientController;
import Models.Report;
import Controllers.ReportController;
import Models.Patient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//for report 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ReportServlet", urlPatterns = {"/ReportServlet"})

public class ReportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int patient_id = Integer.parseInt(request.getParameter("patient_id"));
                String type = request.getParameter("type");
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Report obj = new Report();
                obj.setPatient_id(patient_id);
                obj.setType(type);
                obj.setCategory(category);
                obj.setDescription(description);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    ReportController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int report_id = Integer.parseInt(request.getParameter("report_id"));
                int patient_id = Integer.parseInt(request.getParameter("patient_id"));
                String type = request.getParameter("type");
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Report obj = new Report();
                obj.setReport_id(report_id);
                obj.setPatient_id(patient_id);
                obj.setType(type);
                obj.setCategory(category);
                obj.setDescription(description);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    ReportController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int report_id = Integer.parseInt(request.getParameter("report_id"));
                Report obj = new Report();
                obj.setReport_id(report_id);
                try {
                    ReportController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Report> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = ReportController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getReport_id() + "_" + list.get(i).getPatient_id() + "_" + list.get(i).getType() + "_" + list.get(i).getCategory() + "_" + list.get(i).getDescription() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    //Error
                }

            } else if (action.equals("report")) {
                try {
                    int report_id = Integer.parseInt(request.getParameter("report_id"));
                    String file = "C:/xampp/htdocs/Reports/report.pdf";

                    Document doc = new Document();

                    PdfWriter.getInstance(doc, new FileOutputStream(file));
                    doc.open();

                    Paragraph topic = new Paragraph();
                    topic.add("ABC Laboratory");
                    topic.setAlignment(Element.ALIGN_LEFT);

                    Paragraph d = new Paragraph();
                    d.add(current_date);
                    d.setAlignment(Element.ALIGN_LEFT);

                    Paragraph para = new Paragraph();
                    para.add("Medical Report");
                    para.setAlignment(Element.ALIGN_CENTER);

                    doc.add(topic);
                    doc.add(d);
                    doc.add(para);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);

                    float x[] = {5, 15, 15, 15, 15, 15, 15};

                    PdfPTable table = new PdfPTable(x);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                    table.addCell("ID");
                    table.addCell("Patient ID");
                    table.addCell("Patient Name");
                    table.addCell("Type");
                    table.addCell("Category");
                    table.addCell("Description");
                    table.addCell("Status");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.DARK_GRAY);
                    }

                    Report report = ReportController.getInstance().Search(report_id);
                    Patient patient = PatientController.getInstance().Search(report.getPatient_id());
                    table.addCell(report.getReport_id() + "");
                    table.addCell(report.getPatient_id() + "");
                    table.addCell(patient.getName() + "");
                    table.addCell(report.getType() + "");
                    table.addCell(report.getCategory() + "");
                    table.addCell(report.getDescription() + "");
                    table.addCell(report.getStatus() + "");

                    doc.add(table);

                    doc.close();
                    response.getWriter().println("Report Created!");
                } catch (Exception ex) {
                    response.getWriter().println(ex);
                    //Error
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
