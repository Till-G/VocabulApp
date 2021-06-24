package io.nextlevel.query.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Data
@Entity
public class Queri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ausgangLanguage;
    private String zielLanguage;
    private String ausgangWord;
    private String zielWord;
    private int difficulty;

    private static final int EASY = 4;
    private static final int MEDIUM = 6;
    private static final int HARD = 7;

    public Queri(int id, String ausgangLanguage, String zielLanguage, String ausgangWord, String zielWord, int difficulty){
        this.id = id;
        this.ausgangLanguage = ausgangLanguage;
        this.zielLanguage = zielLanguage;
        this.ausgangWord = ausgangWord;
        this.zielWord = zielWord;
        int wordLength;
        if(ausgangWord.length() > zielWord.length())
            wordLength = ausgangWord.length();
        else
            wordLength = zielWord.length();
        if(wordLength <= EASY)
            this.difficulty = EASY;
        else if(wordLength <= MEDIUM)
            this.difficulty = MEDIUM;
        else
            this.difficulty = HARD;
    }
}
