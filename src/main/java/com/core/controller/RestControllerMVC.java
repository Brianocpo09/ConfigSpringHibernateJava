/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author sistemas
 */

@RestController
public class RestControllerMVC {
    
    @RequestMapping("/rest/mensaje")
    public String pruebaRest(){
       return "hola Brian";
    }
}
