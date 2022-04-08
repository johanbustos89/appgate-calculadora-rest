/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appgate.appgatecalculadorarest;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author johanbustos
 */
public class CalculatorTest {
    
    
    
    @Test
    public void testNuevaOperacion() {
        
        //Esperado
        System.out.println("Test::nuevaOperacion");
        Long expResult = new Long(1);
        
        //Ejecutar y Obtener
        Calculator instance = new Calculator();
        Long result = instance.nuevaOperacion();
        
        //Comparar
        assertEquals(expResult, result);
    }
    
    
      
    @Test
    public void testAgregarOperando() {
        
        System.out.println("Test::AgregarOperando");
        
        //Entradas
        Long operando = new Long(2);
        Long idoperacion = new Long(1);
        
        //Esperado
        ArrayList<Long> expResult = new ArrayList<Long>();
        Calculator instance = new Calculator();
        //expResult.add(operando);
        
        //Ejecutar y Obtener
        ArrayList<Long> result = instance.agregarOperando(operando, idoperacion);
        
        //Comparar
        assertEquals(expResult, result);
    }
    
    
      /**
     * Test of realizarOperacion method, of class Calculator.
     * @param operacionm
     * @param idoperacion
     */
    @Test
    public void testRealizarOperacion() {
        System.out.println("Test::RealizarOperacion");
        String operacion = "suma";
        Long idoperacion = new Long(1);
        Calculator instance = new Calculator();
        Long expResult = new Long(0);
        Long result = instance.realizarOperacion(operacion, idoperacion);
        assertEquals(expResult, result);
    }
    
   
    
}
