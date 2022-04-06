/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appgate.appgatecalculadorarest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
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

        Long resultado = new Long(0);
        try {
            switch (operacion) {

                case "suma": {
                    resultado = operandos.stream().map(ele -> ele).reduce(resultado, (accumulator, _item) -> accumulator + _item);
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }

                case "resta": {
                    for (Long ele : operandos) {

                        resultado -= ele;
                    }
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }

                case "multi": {
                    for (Long ele : operandos) {

                        resultado *= ele;
                    }
                    operandos.clear();
                    operandos.add(resultado);
                    System.out.println("Resultado es:" + resultado);
                    break;
                }

                case "divi": {
                    for (Long ele : operandos) {

                        resultado /= ele;
                    }
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
