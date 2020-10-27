package Servlets;

import Models.Patient;
import Controllers.PatientController;
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

@WebServlet(name = "PatientServlet", urlPatterns = {"/PatientServlet"})

public class PatientServlet extends HttpServlet {

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
                String address = request.getParameter("address");
                String dob = request.getParameter("dob");
                String nic = request.getParameter("nic");
                String contact = request.getParameter("contact");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String date_time = request.getParameter("date_time");
                Patient obj = new Patient();
                obj.setName(name);
                obj.setAddress(address);
                obj.setDob(dob);
                obj.setNic(nic);
                obj.setContact(contact);
                obj.setEmail(email);
                obj.setUsername(username);
                obj.setPassword(password);
                obj.setDate_time(date_time);
                try {
                    PatientController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int patient_id = Integer.parseInt(request.getParameter("patient_id"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String dob = request.getParameter("dob");
                String nic = request.getParameter("nic");
                String contact = request.getParameter("contact");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String date_time = request.getParameter("date_time");
                Patient obj = new Patient();
                obj.setPatient_id(patient_id);
                obj.setName(name);
                obj.setAddress(address);
                obj.setDob(dob);
                obj.setNic(nic);
                obj.setContact(contact);
                obj.setEmail(email);
                obj.setUsername(username);
                obj.setPassword(password);
                obj.setDate_time(date_time);
                try {
                    PatientController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int patient_id = Integer.parseInt(request.getParameter("patient_id"));
                Patient obj = new Patient();
                obj.setPatient_id(patient_id);
                try {
                    PatientController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Patient> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = PatientController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getPatient_id() + "_" + list.get(i).getName() + "_" + list.get(i).getAddress() + "_" + list.get(i).getDob() + "_" + list.get(i).getNic() + "_" + list.get(i).getContact() + "_" + list.get(i).getEmail() + "_" + list.get(i).getUsername() + "_" + list.get(i).getPassword() + "_" + list.get(i).getDate_time() + "_";
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
