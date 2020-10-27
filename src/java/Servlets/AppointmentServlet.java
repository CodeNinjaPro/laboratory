package Servlets;

import Models.Appointment;
import Controllers.AppointmentController;
import Controllers.EmailController;
import Controllers.PatientController;
import Models.Patient;
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

@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})

public class AppointmentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int patient_id = Integer.parseInt(request.getParameter("patient_id"));
                int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
                String appointment_date = request.getParameter("appointment_date");
                String appointment_time = request.getParameter("appointment_time");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Appointment obj = new Appointment();
                obj.setPatient_id(patient_id);
                obj.setDoctor_id(doctor_id);
                obj.setAppointment_date(appointment_date);
                obj.setAppointment_time(appointment_time);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    AppointmentController.getInstance().Save(obj);
                    int appointment_id = AppointmentController.getInstance().getLastID();
                    String file = "C:/xampp/htdocs/Reports/" + appointment_id + ".pdf";

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
                    para.add("Appointment Conformation Report");
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
                    table.addCell("Doctor ID");
                    table.addCell("Date");
                    table.addCell("Time");
                    table.addCell("Status");
                    table.addCell("Time");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.DARK_GRAY);
                    }

                    Appointment appointment = AppointmentController.getInstance().Search(appointment_id);
                    table.addCell(appointment.getAppointment_id() + "");
                    table.addCell(appointment.getPatient_id() + "");
                    table.addCell(appointment.getDoctor_id() + "");
                    table.addCell(appointment.getAppointment_date() + "");
                    table.addCell(appointment.getAppointment_time() + "");
                    table.addCell(appointment.getStatus() + "");
                    table.addCell(appointment.getDate_time() + "");
                    doc.add(table);
                    doc.close();

                    Patient patient = PatientController.getInstance().Search(appointment.getPatient_id());
                    EmailController.getInstance().sendMain(patient.getEmail(), "Appointment Conformation", "This is auto generated mail. Please do not reply", "C:/xampp/htdocs/Reports/" + appointment_id + ".pdf");

                    response.getWriter().println("Saved! Email has been sent to Patient");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
                int patient_id = Integer.parseInt(request.getParameter("patient_id"));
                int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
                String appointment_date = request.getParameter("appointment_date");
                String appointment_time = request.getParameter("appointment_time");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Appointment obj = new Appointment();
                obj.setAppointment_id(appointment_id);
                obj.setPatient_id(patient_id);
                obj.setDoctor_id(doctor_id);
                obj.setAppointment_date(appointment_date);
                obj.setAppointment_time(appointment_time);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    AppointmentController.getInstance().Update(obj);
                    String file = "C:/xampp/htdocs/Reports/" + appointment_id + ".pdf";

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
                    para.add("Appointment Conformation Report");
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
                    table.addCell("Doctor ID");
                    table.addCell("Date");
                    table.addCell("Time");
                    table.addCell("Status");
                    table.addCell("Time");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.DARK_GRAY);
                    }

                    Appointment appointment = AppointmentController.getInstance().Search(appointment_id);
                    table.addCell(appointment.getAppointment_id() + "");
                    table.addCell(appointment.getPatient_id() + "");
                    table.addCell(appointment.getDoctor_id() + "");
                    table.addCell(appointment.getAppointment_date() + "");
                    table.addCell(appointment.getAppointment_time() + "");
                    table.addCell(appointment.getStatus() + "");
                    table.addCell(appointment.getDate_time() + "");
                    doc.add(table);
                    doc.close();

                    Patient patient = PatientController.getInstance().Search(appointment.getPatient_id());
                    EmailController.getInstance().sendMain(patient.getEmail(), "Appointment Conformation", "This is auto generated mail. Please do not reply", "C:/xampp/htdocs/Reports/" + appointment_id + ".pdf");
                    response.getWriter().println("Updated! Email has been sent to Patient");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
                Appointment obj = new Appointment();
                obj.setAppointment_id(appointment_id);
                try {
                    AppointmentController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Appointment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = AppointmentController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getAppointment_id() + "_" + list.get(i).getPatient_id() + "_" + list.get(i).getDoctor_id() + "_" + list.get(i).getAppointment_date() + "_" + list.get(i).getAppointment_time() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
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
