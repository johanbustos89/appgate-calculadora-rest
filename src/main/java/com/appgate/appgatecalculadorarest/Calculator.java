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

    public ArrayList<Long> agregarOperando(Long operando, Long idoperacion) {
        try {
            
            
            if (!idoperacion.equals(counter.longValue())) {
                System.out.println("idOperacion invalido");
            } else {
                
                operandos.add(operando);
                System.out.println("Los operandos son:");
                System.out.println(operandos);
            }
        } catch (Exception e) {
            System.err.println("Ocurrio error:" + e.getMessage());
        }

        return operandos;
    }

    public Long realizarOperacion(String operacion, Long idoperacion) {

        Long resultado = new Long(0);
        try {

            if (!idoperacion.equals(counter.longValue())) {
                System.out.println("idOperacion invalido");
            } else {
                System.out.println("La operacion es:" + operacion);

                switch (operacion) {

                    case "suma": {
                        resultado = operandos.stream().reduce(new Long(0), Long::sum);
                        operandos.clear();
                        operandos.add(resultado);
                        System.out.println("Resultado es:" + resultado);
                        break;
                    }
                    case "resta": {
                        resultado = operandos.stream().reduce(new Long(0), (a, b) -> a - b);
                        operandos.clear();
                        operandos.add(resultado);
                        System.out.println("Resultado es:" + resultado);
                        break;
                    }
                    case "multi": {

                        resultado = operandos.stream().reduce(new Long(1), (a, b) -> a * b);
                        operandos.clear();
                        operandos.add(resultado);
                        System.out.println("Resultado es:" + resultado);
                        break;
                    }
                    case "divi": {
                        resultado = operandos.stream().reduce(new Long(1), (a, b) -> a / b);
                        operandos.clear();
                        operandos.add(resultado);
                        System.out.println("Resultado es:" + resultado);
                        break;
                    }
                    case "poten": {
                        resultado = operandos.stream().reduce(new Long(1), (a, b) -> (long) Math.pow(a, b));
                        operandos.clear();
                        operandos.add(resultado);
                        System.out.println("Resultado es:" + resultado);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Ocurrio error:" + e.getMessage());
        }
        return resultado;
    }
}
