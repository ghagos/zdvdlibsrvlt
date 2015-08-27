/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hagos.controller;

import com.hagos.model.DvdItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ghagos
 */
public class AddDVDServlet extends HttpServlet {

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
        String title = (String) request.getParameter("title");
        String year = (String) request.getParameter("year");
        String genre = (String) request.getParameter("genre");
        String newgenre = (String) request.getParameter("newgenre");
        
        if (newgenre != null && newgenre.length() != 0) {
            genre = newgenre;
        }
        
        List<String> errors = new ArrayList<>();
        if (title == null || title.length() == 0 ) {
            errors.add("Title cannot be empty.");
        }
        if (year == null || year.length() == 0) {
            errors.add("Year cannot be empty.");
        }
        
        RequestDispatcher rd;
        if (errors.isEmpty()) {
            DvdItem dvdItem = new DvdItem(title, year, genre);
            request.setAttribute("dvdItem", dvdItem);
        
            rd = (RequestDispatcher) request.getRequestDispatcher("success.view");
            rd.forward(request, response); 
        } else {
            request.setAttribute("errors", errors);
            rd = (RequestDispatcher) request.getRequestDispatcher("error.view");
            rd.forward(request, response); 
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
