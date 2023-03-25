package com.github.eguadorodrigo.alura_servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<body>");
        out.write("<h1>Olá mundo do servlet!</h1>");
        out.write("<a href=\"/alura_servlet_war_exploded/\">home</a>");
        out.write("</body");
        out.write("</html>");
    }

    public void destroy() {
    }
}