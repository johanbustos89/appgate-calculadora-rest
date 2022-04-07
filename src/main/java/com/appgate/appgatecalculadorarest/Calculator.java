/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appgate.appgatecalculadorarest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 *
 * @author johanbustos
 */
@Service
public class Calculator {

    private final AtomicLong counter = new AtomicLong();
    private final ArrayList<Long> operandos = new ArrayList();

    public Long nuevaOperacion() {
        try {
            operandos.clear();

        } catch (Exception e) {
            System.err.println("Ocurrio error:" + e.getMessage());
        }
        return counter.incrementAndGet();
    }

    public ArrayList<Long> agregarOperando(Long operando) {
        try {
            operandos.add(operando);
            System.out.println("Los operandos son:");
            for (Long ele : operandos) {
                System.out.println(ele);
            }
        } catch (Exception e) {
            System.err.println("Ocurrio error:" + e.getMessage());
        }

        return operandos;
    }

    public Long realizarOperacion(String operacion) {

        System.out.println("La operacion es:" + operacion);

        Long resultado=new Long(0);
        try {
            switch (operacion) {

                case "suma": {
                    //resultado = operandos.stream().parallel().reduce(0,(a,b)->  a + b);
                    
                   // resultado = operandos.stream().map(ele -> ele).reduce(0, (accumulator, _item) -> accumulator + _item);
                    //resultado = operandos.stream().reduce(new Long(0),(a,b)->  a + b);
                    //resultado = operandos.stream().reduce(new Long(0),Long::sum);
                    resultado = operandos.stream().reduce(new Long(0),Long::sum);
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }
                case "resta": {
                    resultado = operandos.stream().reduce(new Long(0),(a,b)->  a - b);
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }
                case "multi": {
                   
                    resultado = operandos.stream().reduce(new Long(1),(a,b)->  a * b);
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }
                case "divi": {
                    resultado = operandos.stream().reduce(new Long(1),(a,b)->  a / b);
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }
                  case "poten": {
                    resultado = operandos.stream().reduce(new Long(1),(a,b)->  (long)Math.pow(a,b));
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Ocurrio error:" + e.getMessage());
        }
        return resultado;
    }
}
