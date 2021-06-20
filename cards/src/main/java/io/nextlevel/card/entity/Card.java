package io.nextlevel.card.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //constructs getter/setter/constructor
@AllArgsConstructor
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


    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nGerman: " + getGerman() +
                "\nEnglish: " + getEnglish() +
                "\nTurkish: " + getTurkish() +
                "\nSpanish: " + getSpanish();
    }
}