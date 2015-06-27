package com.n3vr0s.aubergine.app.utils;

public class NumberUtils {

    private NumberUtils(){}

    public static int getIntFromString(String value){
        int intValue = 0;
        try {
            intValue = Integer.valueOf(value);
        } catch (NumberFormatException exception){

        }

        return intValue;
    }

}
