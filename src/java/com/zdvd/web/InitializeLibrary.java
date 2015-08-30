/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zdvd.web;

import com.zdvd.model.DvdItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author getachew
 */
public class InitializeLibrary implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        try {
            List<DvdItem> dvdList = new ArrayList<>();

            ServletContext context = sce.getServletContext();
            String dataFile = context.getInitParameter("library-file");
            
            is = context.getResourceAsStream(dataFile);      
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            String line;        
            while ((line = br.readLine()) != null) {
                String[] elements = line.split("\\|");
                String title = elements[0];
                String year = elements[1];
                String genre = elements[2];
                dvdList.add(new DvdItem(title, year, genre));
            }
            sce.getServletContext().setAttribute("dvdList", dvdList);
            
            // throw new UnsupportedOperationException("Not supported yet.");
        } catch (IOException ex) {
            Logger.getLogger(InitializeLibrary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(InitializeLibrary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException ex) {
                    Logger.getLogger(InitializeLibrary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(InitializeLibrary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
