/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author patri
 */
@Controller
public class GenreController {
    
    @RequestMapping(value="/displayGenresPage", method=RequestMethod.GET)
    public String displayGenresPage() {
        return "genres";
    }
}
