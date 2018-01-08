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
public class Instrument {
    
    private long instrumentId;
    private String instrumentName;
    private List<Musician> musicians = new ArrayList<>();

    public long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.instrumentId ^ (this.instrumentId >>> 32));
        hash = 19 * hash + Objects.hashCode(this.instrumentName);
        hash = 19 * hash + Objects.hashCode(this.musicians);
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
        final Instrument other = (Instrument) obj;
        if (this.instrumentId != other.instrumentId) {
            return false;
        }
        if (!Objects.equals(this.instrumentName, other.instrumentName)) {
            return false;
        }
        if (!Objects.equals(this.musicians, other.musicians)) {
            return false;
        }
        return true;
    }

   
}
