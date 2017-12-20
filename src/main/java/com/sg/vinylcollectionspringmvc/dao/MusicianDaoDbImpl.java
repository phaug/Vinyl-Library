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
public class MusicianDaoDbImpl implements MusicianDao {

    private static final String SQL_INSERT_MUSICIAN
            = "insert into musicians (firstName, lastName, instrumentId) "
            + "values (?, ?, ?)";
    
    private static final String SQL_INSERT_MUSICANINSTRUMENT
            ="insert into musicianinstrument (musicanId, instrumentId) "
            + "values (?, ?)";
    
    private static final String SQL_INSERT_ALBUMMUSICIAN
            ="insert into albummusician (albumId, musicianId) values (?, ?)";
    
    private static final String SQL_DELETE_MUSICIAN
            = "delete from musicians where musicianId = ?";
    
    private static final String SQL_DELETE_MUSICIANINSTRUMENT
            = "delete from musicianinstrument where musicianId = ?";
    
    private static final String SQL_DELETE_ALBUMMUSICIAN
            ="delete from albummusician where musicianId = ?";
    
    private static final String SQL_UPDATE_MUSICIAN
            = "update musicians set firstName = ?, lastName = ?, "
            + "instrumentId = ? where musicianId = ?";
    
    private static final String SQL_SELECT_ALL_MUSICIANS
            = "select * from musicians";

    @Override
    public Musician addMusician(Musician musician) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeMusician(long musicianId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMusician(Musician musician) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Musician> getAllMusicians() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
