/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Instrument;
import com.sg.vinylcollectionspringmvc.model.Musician;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
            = "update instruments set instrumentName = ?, musicianId = ?"
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
        
        private void insertMusicianInstrument(Instrument instrument) {
            final long instrumentId = instrument.getInstrumentId();
            final List<Musician> musicians = instrument.getMusicians();

            for (Musician currentMusician : musicians) {
                jdbcTemplate.update(SQL_INSERT_MUSICANINSTRUMENT,
                        instrumentId,
                        currentMusician.getMusicianId());
            }
        }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Instrument addInstrument(Instrument instrument) {
        jdbcTemplate.update(SQL_INSERT_INSTRUMENT,
                instrument.getInstrumentName());
        
        instrument.setInstrumentId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        
        insertMusicianInstrument(instrument);
        return instrument;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeInstrument(long instrumentId) {
        jdbcTemplate.update(SQL_DELETE_MUSICIANINSTRUMENT, instrumentId);
        jdbcTemplate.update (SQL_DELETE_INSTRUMENT, instrumentId);
    }    


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateInstrument(Instrument instrument) {
       jdbcTemplate.update(SQL_UPDATE_INSTRUMENT,
               instrument.getInstrumentName(),
               instrument.getInstrumentId());
       
       jdbcTemplate.update(SQL_DELETE_MUSICIANINSTRUMENT, instrument.getInstrumentId());
       insertMusicianInstrument(instrument);
    }

    @Override
    public List<Instrument> getAllInstruments() {
        List<Instrument> instruments = jdbcTemplate.query(SQL_SELECT_ALL_INSTRUMENTS, 
                new InstrumentMapper());
        
        return instruments;
    }

}
