/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import com.sg.vinylcollectionspringmvc.model.Artist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author patri
 */
public class ArtistDaoDbImpl implements ArtistDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String SQL_INSERT_ARTIST
            = "insert into artists (artistName) "
            + "values (?)";

    private static final String SQL_INSERT_ALBUMARTIST
            = "insert into albumartist (albumId, artistId) values (?, ?)";

    public static final String SQL_DELETE_ARTIST
            = "delete from artists where artistId = ?";

    public static final String SQL_DELETE_ALBUMARTIST
            = "delete from albumartist where artistId = ?";

    public static final String SQL_UPDATE_ARTIST
            = "update artists set artistName = ? where artistId = ?";

    public static final String SQL_SELECT_ALL_ARTISTS
            = "select * from artists";

    private static final String SQL_SELECT_ARTIST_BY_ID
            = "select * from artists where artistId = ?";

    private static final class ArtistMapper implements RowMapper<Artist> {

        @Override
        public Artist mapRow(ResultSet rs, int i) throws SQLException {
            Artist artist = new Artist();
            artist.setArtistName(rs.getString("artistName"));
            artist.setArtistId(rs.getInt("artistId"));
            return artist;
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

    @Override
    public Artist addArtist(Artist artist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArtist(long artistId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArtist(Artist artist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Artist> getAllArtists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Artist getArtistById(long artistId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Artist> searchArtists(Map<Search, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
