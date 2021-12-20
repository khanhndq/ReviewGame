<%-- 
    Document   : logout
    Created on : Nov 5, 2019, 4:01:01 PM
    Author     : NguyenKhanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") != null) {
        session.removeAttribute("username");
        session.removeAttribute("typeaccount");
            session.removeAttribute("iduser");
    }
    response.sendRedirect("Home.jsp");
%>