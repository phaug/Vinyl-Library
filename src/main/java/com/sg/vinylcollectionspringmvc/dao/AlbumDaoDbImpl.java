/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
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
public class AlbumDaoDbImpl implements AlbumDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String SQL_INSERT_ALBUM
            = "insert into albums (albumTitle, albumYear) "
            + "values (?, ?)";

    private static final String SQL_INSERT_ALBUMARTIST
            = "insert into albumartist (albumId, artistId) values (?, ?)";

    private static final String SQL_INSERT_ALBUMGENRE
            = "insert into albumgenre (albumId, genreId) values (?, ?)";

    private static final String SQL_INSERT_ALBUMSONG
            = "insert into albumsong (albumId, songId) values (?, ?)";

    private static final String SQL_INSERT_ALBUMMUSICIAN
            = "insert into albummusician (albumId, musicianId) values (?, ?)";

    public static final String SQL_DELETE_ALBUM
            = "delete from albums where albumId = ?";

    public static final String SQL_DELETE_ALBUMARTIST
            = "delete from albumartist where albumId = ?";

    private static final String SQL_DELETE_ALBUMGENRE
            = "delete from albumgenre where albumId = ?";

    private static final String SQL_DELETE_ALBUMSONG
            = "delete from albumsong where albumId = ?";

    private static final String SQL_DELETE_ALBUMMUSICIAN
            = "delete from albummusician where albumId = ?";

    public static final String SQL_UPDATE_ALBUM
            = "update artists set albumTitle = ?, albumYear = ? where artistId = ?";

    public static final String SQL_SELECT_ALL_ALBUMS
            = "select * from albums";

    private static final String SQL_SELECT_ARTIST_BY_ID
            = "select * from albums where albumId = ?";
    
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
    public Album addAlbum(Album album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAlbum(long albumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAlbum(Album album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> getAllAlbums() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album getAlbumById(long albumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> searchAlbums(Map<Search, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
