/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.netty.client;

import java.util.Date;

/**
 * Actually this class should be defined in a common lib shared by Server and Client
 * @author winnie
 */
class UnixTime {

    private final int value;

    public UnixTime() {
        this((int) (System.currentTimeMillis() / 1000L + 2208988800L));
    }

    public UnixTime(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString();
    }
    
}
