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
public class Musician {
    
    private long memberId;
    private String firstName;
    private String lastName;
    private List<Instrument> instruments = new ArrayList<>();
}
