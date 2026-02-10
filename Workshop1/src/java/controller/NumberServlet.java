/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name="NumberServlet", urlPatterns={"/number"})
public class NumberServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NumberServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NumberServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String num3 = request.getParameter("num3");
        String op = request.getParameter("operation");
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            double n3 = Double.parseDouble(num3);
            
            switch (op) {
                case "add12":
                    response.getWriter().print("<h1> Result: </h1>" + (n1+n2));
                    break;
                case "add23":
                    response.getWriter().print("<h1> Result: </h1>" + (n2+n3));
                    break;
                case "sub31":
                    response.getWriter().print("<h1> Result: </h1>" + (n3-n1));
                    break;
                case "mul32":
                    response.getWriter().print("<h1> Result: </h1>" + (n3*n2));
                    break;
                case "div12":
                    if (n2 == 0) {
                        response.getWriter().print("<h1>Cannot divide by zero.</h1>");
                    } else {
                        response.getWriter().print("<h1> Result: </h1>" + (n1/n2));
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            response.getWriter().print("<h1>Invalid input.</h1>");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
