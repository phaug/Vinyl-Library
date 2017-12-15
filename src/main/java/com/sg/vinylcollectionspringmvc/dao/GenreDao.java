/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Genre;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patri
 */
public interface GenreDao {
    
    public GenreDao addGenre (Genre genre);
    
    public void removeGenre (long genreId);
    
    public void updateGenre (Genre genre);
    
    public List<GenreDao> getAllGenres();
    
    public Genre getGenreById (long genreId);
    
    public List<Genre> searchGenres(Map<Search, String> criteria);
    
}
