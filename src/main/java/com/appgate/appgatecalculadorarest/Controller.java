/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appgate.appgatecalculadorarest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johanbustos
 */
@RestController
public class Controller {

    @Autowired
    Calculator calculadora;

    @GetMapping("/nuevaOperacion")
    public Long nuevaOperacion() {
        return calculadora.nuevaOperacion();
    }

    @GetMapping("/agregarOperando")
    public ArrayList<Long> agregarOperando(@RequestParam(value = "operando") Long operando, @RequestParam(value = "idoperacion") Long idoperacion) {
        return calculadora.agregarOperando(operando,idoperacion);
    }

    @GetMapping("/realizarOperacion")
    public Long realizarOperacion(@RequestParam(value = "operacion") String operacion,@RequestParam(value = "idoperacion") Long idoperacion) {
        return calculadora.realizarOperacion(operacion, idoperacion);
    }
}
