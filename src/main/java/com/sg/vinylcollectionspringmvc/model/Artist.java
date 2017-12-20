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
    private List<Album> albums = new ArrayList<>();

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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.artistId ^ (this.artistId >>> 32));
        hash = 13 * hash + Objects.hashCode(this.ArtistName);
        hash = 13 * hash + Objects.hashCode(this.albums);
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
        if (!Objects.equals(this.ArtistName, other.ArtistName)) {
            return false;
        }
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        return true;
    }

}
