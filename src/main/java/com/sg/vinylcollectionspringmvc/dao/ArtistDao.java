/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Artist;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patri
 */
public interface ArtistDao {
    
    public Artist addArtist (Artist artist);

    public void removeArtist (long artistId);
    
    public void updateArtist (Artist artist);

    public List<Artist> getAllArtists();

    public Artist getArtistById(long artistId);

    public List<Artist> searchArtists(Map<Search, String> criteria);
}
