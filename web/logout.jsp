<%-- 
    Document   : logout
    Created on : Oct 27, 2020, 3:33:48 PM
    Author     : Roshan Withanage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    session.invalidate();
    response.sendRedirect("login.jsp");
    %>
</html>
