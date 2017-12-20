/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Instrument;
import java.util.List;

/**
 *
 * @author patri
 */
public class InstrumentDaoDbImpl implements InstrumentDao {

    private static final String SQL_INSERT_INSTRUMENT
            = "insert into instruments (instrumentName) values (?)";
    
    private static final String SQL_INSERT_MUSICANINSTRUMENT
            = "insert into musicianinstrument (musicanId, instrumentId) "
            + "values (?, ?)";
    
    private static final String SQL_DELETE_INSTRUMENT
            = "delete from instruments where instrumentId = ?";

    private static final String SQL_DELETE_MUSICIANINSTRUMENT
            = "delete from musicianinstrument where instrumentId = ?";

    private static final String SQL_UPDATE_INSTRUMENT
            = "update instruments set instrumentName = ?"
            + "where instrumentId = ?";
    
    private static final String SQL_SELECT_ALL_INSTRUMENTS
            = "select * from instruments";

    @Override
    public Instrument addInstrument(Instrument instrument) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeInstrument(long instrumentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateInstrument(Instrument instrument) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Instrument> getAllInstruments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
