package org.java.web;

import java.io.IOException;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       String name=request.getParameter("name");
       request.setAttribute("uname",name);
       request.getRequestDispatcher("/show.jsp").forward(request,response);
    }

}
