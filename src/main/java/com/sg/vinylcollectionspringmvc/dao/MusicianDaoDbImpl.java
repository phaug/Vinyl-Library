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
public class MusicianDaoDbImpl implements MusicianDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_MUSICIAN
            = "insert into musicians (firstName, lastName, instrumentId) "
            + "values (?, ?, ?)";

    private static final String SQL_INSERT_MUSICANINSTRUMENT
            = "insert into musicianinstrument (musicanId, instrumentId) "
            + "values (?, ?)";

    private static final String SQL_INSERT_ALBUMMUSICIAN
            = "insert into albummusician (albumId, musicianId) values (?, ?)";

    private static final String SQL_DELETE_MUSICIAN
            = "delete from musicians where musicianId = ?";

    private static final String SQL_DELETE_MUSICIANINSTRUMENT
            = "delete from musicianinstrument where musicianId = ?";

    private static final String SQL_DELETE_ALBUMMUSICIAN
            = "delete from albummusician where musicianId = ?";

    private static final String SQL_UPDATE_MUSICIAN
            = "update musicians set firstName = ?, lastName = ?, "
            + "instrumentId = ? where musicianId = ?";

    private static final String SQL_SELECT_ALL_MUSICIANS
            = "select * from musicians";

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

    private static final class AlbumMapper implements RowMapper<Album> {

        @Override
        public Album mapRow(ResultSet rs, int i) throws SQLException {
            Album album = new Album();
            album.setAlbumTitle(rs.getString("albumTitle"));
            album.setAlbumYear(rs.getString("albumYear"));
            album.setAlbumId(rs.getInt("albumId"));
            return album;
        }

    }

    private static final class InstrumentMapper implements RowMapper<Instrument> {

        @Override
        public Instrument mapRow(ResultSet rs, int i) throws SQLException {
            Instrument instrument = new Instrument();
            instrument.setInstrumentName(rs.getString("instrumentName"));
            instrument.setInstrumentId(rs.getInt("instrumentId"));
            return instrument;
        }

    }

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
