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
public class Album {
    
    private long AlbumId;
    private String albumTitle;
    private String albumYear;
    private List<Artist> artist = new ArrayList<>();
    private List<Musician> musicians = new ArrayList<>();
    private List<Genre> genre = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();

    public long getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(long AlbumId) {
        this.AlbumId = AlbumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(String albumYear) {
        this.albumYear = albumYear;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.AlbumId ^ (this.AlbumId >>> 32));
        hash = 53 * hash + Objects.hashCode(this.albumTitle);
        hash = 53 * hash + Objects.hashCode(this.albumYear);
        hash = 53 * hash + Objects.hashCode(this.artist);
        hash = 53 * hash + Objects.hashCode(this.musicians);
        hash = 53 * hash + Objects.hashCode(this.genre);
        hash = 53 * hash + Objects.hashCode(this.songs);
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
        final Album other = (Album) obj;
        if (this.AlbumId != other.AlbumId) {
            return false;
        }
        if (!Objects.equals(this.albumTitle, other.albumTitle)) {
            return false;
        }
        if (!Objects.equals(this.albumYear, other.albumYear)) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.musicians, other.musicians)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.songs, other.songs)) {
            return false;
        }
        return true;
    }
    
}
