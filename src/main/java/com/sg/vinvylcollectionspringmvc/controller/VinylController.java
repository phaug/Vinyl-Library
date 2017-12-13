/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinvylcollectionspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author patri
 */
@Controller
public class VinylController {
    
    @RequestMapping(value="/displayVinylLibraryPage", method=RequestMethod.GET)
    public String displayVinylLibraryPage() {
        return "vinylLibrary";
    }
}
