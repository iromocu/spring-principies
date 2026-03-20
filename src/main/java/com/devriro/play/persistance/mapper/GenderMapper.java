package com.devriro.play.persistance.mapper;

import com.devriro.play.domain.enums.Gender;
import org.mapstruct.Named;

public class GenderMapper {
    @Named("stringToGender")
    public static Gender stringToGender(String gender){
        if(gender.isBlank()) return null;
        return switch (gender.toUpperCase()){
            case "ACCION" -> Gender.ACTION;
            case "COMEDIA" -> Gender.COMEDY;
            case "DRAMA" -> Gender.DRAMA;
            case "ANIMADA" -> Gender.ANIMATED;
            case "TERROR" -> Gender.HORROR;
            case "CIENCIA_FICCION" -> Gender.SCI_FI;
            default -> null;
        };
    }

    @Named("genderToString")
    public static String genderToString(Gender gender){
        if(gender == null) return null;
        return switch (gender){
            case Gender.ACTION -> "ACCION";
            case Gender.COMEDY -> "COMEDIA";
            case Gender.DRAMA -> "DRMA";
            case Gender.ANIMATED -> "ANIMADA";
            case Gender.HORROR -> "TERROR";
            case Gender.SCI_FI -> "CIENCIA_FICCION";
            default -> null;
        };
    }
}
