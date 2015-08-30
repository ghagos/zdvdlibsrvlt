/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zdvd.model;

import java.io.Serializable;

/**
 *
 * @author ghagos
 */
public class DvdItem implements Serializable {
    private String title;
    private String year;
    private String genre;

    public DvdItem(String title, String year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
