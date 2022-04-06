/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appgate.appgatecalculadorarest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EUO5188A
 */
@RestController
public class Controller {

    @GetMapping("/nuevaOperacion")
    public int nuevaOperacion() {
        return 1;
    }

    @GetMapping("/agregarOperando")
    public int agregarOperando() {
        return 2;
    }

    @GetMapping("/realizarOperacion")
    public int realizarOperacion() {
        return 3;
    }
}
