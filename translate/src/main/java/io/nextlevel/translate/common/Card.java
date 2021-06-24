package io.nextlevel.translate.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //constructs getter/setter/constructor
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int id;
    String set;
    String german;
    String english;
    String turkish;
    String spanish;


    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nGerman: " + getGerman() +
                "\nEnglish: " + getEnglish() +
                "\nTurkish: " + getTurkish() +
                "\nSpanish: " + getSpanish();
    }
}