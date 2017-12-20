/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Song;
import java.util.List;

/**
 *
 * @author patri
 */
public class SongDaoDbImpl implements SongDao {
    
    private static final String SQL_INSERT_SONG
            ="insert into songs "
            + "(songName, songLength) "
            + "values (?, ?)";
    
    private static final String SQL_INSERT_ALBUMSONG
            ="insert into albumsong (albumId, songId) values (?, ?)";
    
    private static final String SQL_DELETE_SONG
            ="delete from songs where songId = ?";
    
    private static final String SQL_DELETE_ALBUMSONG
            ="delete from albumsong where songId = ?";
    
    private static final String SQL_UPDATE_SONG
            ="update songs set"
            + "songName = ?, songLength = ?"
            + "where songId = ?";
    
    private static final String SQL_SELECT_ALL_SONGS
            ="select * from songs";

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
