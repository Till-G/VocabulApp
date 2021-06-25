package io.nextlevel.frontend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //constructs getter/setter/constructor
@NoArgsConstructor
public class Card {
    private int id;
    String set;
    String german;
    String english;
    String turkish;
    String spanish;

    public Card(int id, String set, String german, String english, String turkish, String spanish){
        this.id = id;
        this.set = set.trim();
        this.german = german.trim();
        this.english = english.trim();
        this.turkish = turkish.trim();
        this.spanish = spanish.trim();
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nGerman: " + getGerman() +
                "\nEnglish: " + getEnglish() +
                "\nTurkish: " + getTurkish() +
                "\nSpanish: " + getSpanish();
    }
}
