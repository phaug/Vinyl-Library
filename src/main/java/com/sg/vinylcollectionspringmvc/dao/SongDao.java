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
public interface SongDao {
    
    public Song addSong (Song song);
    
    public void removeSong (long songId);
    
    public void updateSong (Song song);
    
    public List<Song> getAllSongs();
    
    
}
