<%-- 
    Document   : Post-delete
    Created on : Nov 10, 2019, 8:13:00 PM
    Author     : ASUS
--%>

<%@page import="Model.PostModel"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    PostModel gm = new PostModel();
    int id = Integer.parseInt(request.getParameter("id"));
    int p = 1;
    String s = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    boolean check = gm.deletePost(id);
    if (check == true) {
        response.sendRedirect("Post-list.jsp?page=" + p + "&s=" + s);
    }%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>