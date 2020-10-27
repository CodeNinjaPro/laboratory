package Servlets;

import Controllers.AppointmentController;
import Controllers.EmailController;
import Controllers.PatientController;
import Models.Payment;
import Controllers.PaymentController;
import Controllers.ReportController;
import Models.Appointment;
import Models.Patient;
import Models.Report;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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

@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})

public class PaymentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                String date_time = request.getParameter("date_time");
                Payment obj = new Payment();
                obj.setAppointment_id(appointment_id);
                obj.setAmount(amount);
                obj.setDate_time(date_time);
                try {
                    PaymentController.getInstance().Save(obj);
                    int payment_id = PaymentController.getInstance().getLastID();
                    String file = "C:/xampp/htdocs/Reports/" + payment_id + ".pdf";

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
                    para.add("Payment Conformation Report");
                    para.setAlignment(Element.ALIGN_CENTER);

                    doc.add(topic);
                    doc.add(d);
                    doc.add(para);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);

                    float x[] = {5, 15, 15, 15};

                    PdfPTable table = new PdfPTable(x);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                    table.addCell("ID");
                    table.addCell("Appointment ID");
                    table.addCell("Amount");
                    table.addCell("Date");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.DARK_GRAY);
                    }

                    Payment payment = PaymentController.getInstance().Search(payment_id);
                    table.addCell(payment.getPayment_id() + "");
                    table.addCell(payment.getAppointment_id() + "");
                    table.addCell(payment.getAmount() + "");
                    table.addCell(payment.getDate_time() + "");
                    doc.add(table);
                    doc.close();

                    Appointment appointment = AppointmentController.getInstance().Search(payment.getAppointment_id());
                    Patient patient = PatientController.getInstance().Search(appointment.getPatient_id());
                    EmailController.getInstance().sendMain(patient.getEmail(), "Appointment Conformation", "This is auto generated mail. Please do not reply", "C:/xampp/htdocs/Reports/" + appointment_id + ".pdf");

                    response.getWriter().println("Saved! Email has been sent to Patient");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int payment_id = Integer.parseInt(request.getParameter("payment_id"));
                int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                String date_time = request.getParameter("date_time");
                Payment obj = new Payment();
                obj.setPayment_id(payment_id);
                obj.setAppointment_id(appointment_id);
                obj.setAmount(amount);
                obj.setDate_time(date_time);
                try {
                    PaymentController.getInstance().Update(obj);
                    String file = "C:/xampp/htdocs/Reports/" + payment_id + ".pdf";

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
                    para.add("Payment Conformation Report");
                    para.setAlignment(Element.ALIGN_CENTER);

                    doc.add(topic);
                    doc.add(d);
                    doc.add(para);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);

                    float x[] = {5, 15, 15, 15};

                    PdfPTable table = new PdfPTable(x);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                    table.addCell("ID");
                    table.addCell("Appointment ID");
                    table.addCell("Amount");
                    table.addCell("Date");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.DARK_GRAY);
                    }

                    Payment payment = PaymentController.getInstance().Search(payment_id);
                    table.addCell(payment.getPayment_id() + "");
                    table.addCell(payment.getAppointment_id() + "");
                    table.addCell(payment.getAmount() + "");
                    table.addCell(payment.getDate_time() + "");
                    doc.add(table);
                    doc.close();

                    Appointment appointment = AppointmentController.getInstance().Search(payment.getAppointment_id());
                    Patient patient = PatientController.getInstance().Search(appointment.getPatient_id());
                    EmailController.getInstance().sendMain(patient.getEmail(), "Appointment Conformation", "This is auto generated mail. Please do not reply", "C:/xampp/htdocs/Reports/" + appointment_id + ".pdf");
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int payment_id = Integer.parseInt(request.getParameter("payment_id"));
                Payment obj = new Payment();
                obj.setPayment_id(payment_id);
                try {
                    PaymentController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Payment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = PaymentController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getPayment_id() + "_" + list.get(i).getAppointment_id() + "_" + list.get(i).getAmount() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    //Error
                }

            } else if (action.equals("serch_p")) {
                try {
                    
                    int payment_id = Integer.parseInt(request.getParameter("payment_id"));
                    
                    List<Payment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();             
                    

                    list = PaymentController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getPayment_id() + "_" + list.get(i).getAppointment_id() + "_" + list.get(i).getAmount() + "_" + list.get(i).getDate_time() + "_";
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
