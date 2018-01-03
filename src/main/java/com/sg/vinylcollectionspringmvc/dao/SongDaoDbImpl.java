/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import com.sg.vinylcollectionspringmvc.model.Song;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author patri
 */
public class SongDaoDbImpl implements SongDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_SONG
            = "insert into songs "
            + "(songName, songLength) "
            + "values (?, ?)";

    private static final String SQL_INSERT_ALBUMSONG
            = "insert into albumsong (albumId, songId) values (?, ?)";

    private static final String SQL_DELETE_SONG
            = "delete from songs where songId = ?";

    private static final String SQL_DELETE_ALBUMSONG
            = "delete from albumsong where songId = ?";

    private static final String SQL_UPDATE_SONG
            = "update songs set"
            + "songName = ?, songLength = ?"
            + "where songId = ?";

    private static final String SQL_SELECT_ALL_SONGS
            = "select * from songs";

    private static final class SongMapper implements RowMapper<Song> {

        @Override
        public Song mapRow(ResultSet rs, int i) throws SQLException {
            Song song = new Song();
            song.setSongName(rs.getString("songName"));
            song.setSongLength(rs.getInt("songLength"));
            song.setSongId(rs.getInt("songId"));
            return song;
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
    public Song addSong(Song song) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSong(long songId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSong(Song song) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Song> getAllSongs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
