package io.nextlevel.query.common;

import io.nextlevel.query.Entity.Card;
import io.nextlevel.query.Entity.Queri;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor
public class CardToQueri {
    public static Queri CardToQuery(Card card, String aLanguage, String zLanguage){
        Queri tempQ = new Queri();
        aLanguage = aLanguage.toLowerCase(Locale.ROOT);
        zLanguage = zLanguage.toLowerCase(Locale.ROOT);
        switch (aLanguage) {
            case "german":
                tempQ.setAusgangLanguage("german");
                tempQ.setAusgangWord(card.getGerman());
                break;
            case "english":
                tempQ.setAusgangLanguage("english");
                tempQ.setAusgangWord(card.getEnglish());
                break;
            case "turkish":
                tempQ.setAusgangLanguage("turkish");
                tempQ.setAusgangWord(card.getTurkish());
                break;
            case "spanish":
                tempQ.setAusgangLanguage("spanish");
                tempQ.setAusgangWord(card.getSpanish());
                break;
        }
        switch (zLanguage) {
            case "german":
                tempQ.setZielLanguage("german");
                tempQ.setZielWord(card.getGerman());
                break;
            case "english":
                tempQ.setZielLanguage("english");
                tempQ.setZielWord(card.getEnglish());
                break;
            case "turkish":
                tempQ.setZielLanguage("turkish");
                tempQ.setZielWord(card.getTurkish());
                break;
            case "spanish":
                tempQ.setZielLanguage("spanish");
                tempQ.setZielWord(card.getSpanish());
                break;
        }
        Queri q = new Queri(0, tempQ.getAusgangLanguage(), tempQ.getZielLanguage(), tempQ.getAusgangWord(), tempQ.getZielWord(), 0);
        return q;
    }
}
