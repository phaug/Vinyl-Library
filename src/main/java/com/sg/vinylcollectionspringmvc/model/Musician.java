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
public class Musician {

    private long musicianId;
    private String firstName;
    private String lastName;
    private List<Instrument> instruments = new ArrayList<>();
    private List<Album> albums = new ArrayList<>();

    public long getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(long musicianId) {
        this.musicianId = musicianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
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
        hash = 13 * hash + (int) (this.musicianId ^ (this.musicianId >>> 32));
        hash = 13 * hash + Objects.hashCode(this.firstName);
        hash = 13 * hash + Objects.hashCode(this.lastName);
        hash = 13 * hash + Objects.hashCode(this.instruments);
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
        final Musician other = (Musician) obj;
        if (this.musicianId != other.musicianId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.instruments, other.instruments)) {
            return false;
        }
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        return true;
    }

    

    
}
