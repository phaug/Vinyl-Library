/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author patri
 */
public class Artist {
    
    private long artistId;
    private String ArtistName;
    private long albumId;
    private List<Musician> musicians = new ArrayList<>();

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String ArtistName) {
        this.ArtistName = ArtistName;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.artistId ^ (this.artistId >>> 32));
        hash = 97 * hash + Objects.hashCode(this.ArtistName);
        hash = 97 * hash + (int) (this.albumId ^ (this.albumId >>> 32));
        hash = 97 * hash + Objects.hashCode(this.musicians);
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
        final Artist other = (Artist) obj;
        if (this.artistId != other.artistId) {
            return false;
        }
        if (this.albumId != other.albumId) {
            return false;
        }
        if (!Objects.equals(this.ArtistName, other.ArtistName)) {
            return false;
        }
        if (!Objects.equals(this.musicians, other.musicians)) {
            return false;
        }
        return true;
    }
    
    
}
