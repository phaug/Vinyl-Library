/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.model;

import java.util.Objects;

/**
 *
 * @author patri
 */
public class Genre {
    
    private long genreId;
    private String genreName;

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.genreId ^ (this.genreId >>> 32));
        hash = 29 * hash + Objects.hashCode(this.genreName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genre other = (Genre) obj;
        if (this.genreId != other.genreId) {
            return false;
        }
        if (!Objects.equals(this.genreName, other.genreName)) {
            return false;
        }
        return true;
    }
    
}
