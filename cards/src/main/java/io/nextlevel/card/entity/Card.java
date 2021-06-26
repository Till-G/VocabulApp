package io.nextlevel.card.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //constructs getter/setter/constructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String set;
    String german;
    String english;
    String turkish;
    String spanish;

    public Card(int id, String set, String german, String english, String turkish, String spanish){
        this.id = id;
        this.set = set.trim();
        if(german != null)
            this.german = german.trim();
        else
            this.german = german;
        if(english != null)
            this.english = english.trim();
        else
            this.english = english;
        if(turkish != null)
            this.turkish = turkish.trim();
        else
            this.turkish = null;
        if(spanish != null)
            this.spanish = spanish.trim();
        else
            this.spanish = spanish;
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