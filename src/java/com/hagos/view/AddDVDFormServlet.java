/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hagos.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GHagos
 */
public class AddDVDFormServlet extends HttpServlet {

    private String [] genres;

    @Override
    public void init() throws ServletException {
        String temp = getInitParameter("genre-list");
        if (temp != null && temp.length() != 0) {
            genres = temp.split(",");
        }
        super.init();
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            
            ArrayList<String> errors = (ArrayList) request.getAttribute("errors");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddDVDFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Servlet AddDVDFormServlet at " + request.getContextPath() + "</h3>");
            
            if (errors != null && !errors.isEmpty()) {
                out.println("<font color='red'>Please correct the following error(s):");
                for (String error : errors) {
                    out.println("<li>" + error + "</li>");
                }
                out.println("</font>");
            }
            out.println("<br>");
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String newgenre = request.getParameter("newgenre");
            String genre = request.getParameter("genre");
            
            out.println("<form action=\"adddvdservlet.do\" method=\"POST\">");
            out.println("Title: <input type=\"text\" name=\"title\" value=\""+ (title == null ? "" : title) + "\"><br>");
            out.println("Year: <input type=\"text\" name=\"year\" value=\""+ (year  == null ? "" : year) + "\"><br>");
            out.println("Genre: ");
            
            out.println("<select name=\"genre\">");
            for (String g : genres) {
                out.println("<option value=\"" + g.trim() + "\""+ (g.trim().equals(genre) ? " selected" : "") + ">" + g.trim() + "</option>");
            }
            out.println("</select> ");
            
            out.println("or New Genre: <input type=\"text\" name=\"newgenre\" value=\""+ (newgenre  == null ? "" : newgenre) + "\"><br><br>");
            out.println("<input type=\"submit\" value=\"Add DVD\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
