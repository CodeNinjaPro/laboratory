package Servlets;

import Models.Doctor;
import Controllers.DoctorController;
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

@WebServlet(name = "DoctorServlet", urlPatterns = {"/DoctorServlet"})

public class DoctorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String name = request.getParameter("name");
                String specialization = request.getParameter("specialization");
                String available_days = request.getParameter("available_days");
                String available_time = request.getParameter("available_time");
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                String date_time = request.getParameter("date_time");
                Doctor obj = new Doctor();
                obj.setName(name);
                obj.setSpecialization(specialization);
                obj.setAvailable_days(available_days);
                obj.setAvailable_time(available_time);
                obj.setEmail(email);
                obj.setContact(contact);
                obj.setDate_time(date_time);
                try {
                    DoctorController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
                String name = request.getParameter("name");
                String specialization = request.getParameter("specialization");
                String available_days = request.getParameter("available_days");
                String available_time = request.getParameter("available_time");
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                String date_time = request.getParameter("date_time");
                Doctor obj = new Doctor();
                obj.setDoctor_id(doctor_id);
                obj.setName(name);
                obj.setSpecialization(specialization);
                obj.setAvailable_days(available_days);
                obj.setAvailable_time(available_time);
                obj.setEmail(email);
                obj.setContact(contact);
                obj.setDate_time(date_time);
                try {
                    DoctorController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
                Doctor obj = new Doctor();
                obj.setDoctor_id(doctor_id);
                try {
                    DoctorController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Doctor> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = DoctorController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getDoctor_id() + "_" + list.get(i).getName() + "_" + list.get(i).getSpecialization() + "_" + list.get(i).getAvailable_days() + "_" + list.get(i).getAvailable_time() + "_" + list.get(i).getEmail() + "_" + list.get(i).getContact() + "_" + list.get(i).getDate_time() + "_";
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
