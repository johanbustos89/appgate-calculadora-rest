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
          operandos.clear();
        return counter.incrementAndGet();
     }
    
}
