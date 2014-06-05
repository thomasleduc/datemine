/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.Business;

import lombok.Getter;

/**
 * The checking constrain.
 */
public enum CheckingConstrain {
    /**
     * The login limits.
     */
    LOGIN(4, 45),
    /**
     * The password limits.
     */
    PASSWORD(5, 70),
    /**
     * The Project name length.
     */
    PROJECT_NAME(4, 120);
    
    @Getter
    private final int min;
    @Getter
    private final int max;
    private CheckingConstrain(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
