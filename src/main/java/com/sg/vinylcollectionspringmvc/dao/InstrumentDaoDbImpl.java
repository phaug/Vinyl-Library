/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import com.sg.vinylcollectionspringmvc.model.Instrument;
import com.sg.vinylcollectionspringmvc.model.Musician;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author patri
 */
public class InstrumentDaoDbImpl implements InstrumentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    private static final class InstrumentMapper implements RowMapper<Instrument> {

        @Override
        public Instrument mapRow(ResultSet rs, int i) throws SQLException {
            Instrument instrument = new Instrument();
            instrument.setInstrumentName(rs.getString("instrumentName"));
            instrument.setInstrumentId(rs.getInt("instrumentId"));
            return instrument;
        }

    }
    
        private static final class MusicianMapper implements RowMapper<Musician> {

        @Override
        public Musician mapRow(ResultSet rs, int i) throws SQLException {
            Musician musician = new Musician();
            musician.setFirstName(rs.getString("firstName"));
            musician.setLastName(rs.getString("lastName"));
            musician.setMusicianId(rs.getInt("musicianId"));
            return musician;
        }

    }  


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
