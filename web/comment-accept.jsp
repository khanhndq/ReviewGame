<%-- 
    Document   : comment-delete
    Created on : Nov 8, 2019, 7:55:27 PM
    Author     : José
--%>

<%@page import="Model.CommentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CommentModel cm = new CommentModel();
    int id = Integer.parseInt(request.getParameter("idComment"));
    int p = 1;
    String s = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    boolean check = cm.AcceptComment(id);
    if (check == true) {
        response.sendRedirect("CommentAdmin.jsp?page=" + p + "&s=" + s);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
