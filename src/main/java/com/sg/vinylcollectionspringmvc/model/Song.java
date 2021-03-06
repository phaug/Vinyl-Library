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
public class Song {
    
    private long songId;
    private String songName;
    private long songLength;
    private List<Album> albums = new ArrayList<>();

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public long getSongLength() {
        return songLength;
    }

    public void setSongLength(long songLength) {
        this.songLength = songLength;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.songId ^ (this.songId >>> 32));
        hash = 79 * hash + Objects.hashCode(this.songName);
        hash = 79 * hash + (int) (this.songLength ^ (this.songLength >>> 32));
        hash = 79 * hash + Objects.hashCode(this.albums);
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
        final Song other = (Song) obj;
        if (this.songId != other.songId) {
            return false;
        }
        if (this.songLength != other.songLength) {
            return false;
        }
        if (!Objects.equals(this.songName, other.songName)) {
            return false;
        }
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        return true;
    }

    
}
