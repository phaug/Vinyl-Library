/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Musician;
import java.util.List;

/**
 *
 * @author patri
 */
public interface MusicianDao {
    
    public Musician addMusician (Musician musician);
    
    public void removeMusician (long musicianId);
    
    public void updateMusician (Musician musician);
    
    public List<Musician> getAllMusicians();
    
}
