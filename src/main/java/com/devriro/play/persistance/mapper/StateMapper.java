package com.devriro.play.persistance.mapper;

import org.mapstruct.Named;

public class StateMapper {
    @Named("boolToString")
    public static String boolToString(boolean state){
        return state ? "ACTIVE" : "INACTIVE";
    }

    @Named("stringToBool")
    public static boolean stringToBool(String state){
        return  state.equalsIgnoreCase("ACTIVE");
    }
}
