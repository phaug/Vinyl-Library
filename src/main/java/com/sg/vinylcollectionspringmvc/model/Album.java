/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patri
 */
public class Album {
    
    private long AlbumId;
    private String albumTitle;
    private String albumYear;
    private List<Artist> artist = new ArrayList<>();
    private List<Musician> musicians = new ArrayList<>();
    private List<Genre> genre = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();
    
    
    
}
