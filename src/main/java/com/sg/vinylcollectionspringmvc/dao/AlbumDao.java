/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patri
 */
public interface AlbumDao {
    
        
    public Album addAlbum (Album album);

    public void removeAlbum (long albumId);
    
    public void updateAlbum (Album album);

    public List<Album> getAllAlbums();

    public Album getAlbumById(long albumId);

    public List<Album> searchAlbums(Map<Search, String> criteria);
    
}
