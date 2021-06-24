package io.nextlevel.translate.common;

import io.nextlevel.translate.entity.Translate;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
public class CardToTranslate {
    public static Translate CardToTranslate(Card card, String aLanguage, String zLanguage) {
        Translate translate = new Translate();
        aLanguage = aLanguage.toLowerCase(Locale.ROOT);
        zLanguage = zLanguage.toLowerCase(Locale.ROOT);
        switch (aLanguage) {
            case "german":
                translate.setAusgangLanguage("german");
                translate.setAusgangWord(card.getGerman().toLowerCase(Locale.ROOT));
                break;
            case "english":
                translate.setAusgangLanguage("english");
                translate.setAusgangWord(card.getEnglish().toLowerCase(Locale.ROOT));
                break;
            case "turkish":
                translate.setAusgangLanguage("turkish");
                translate.setAusgangWord(card.getTurkish().toLowerCase(Locale.ROOT));
                break;
            case "spanish":
                translate.setAusgangLanguage("spanish");
                translate.setAusgangWord(card.getSpanish().toLowerCase(Locale.ROOT));
                break;
        }
        switch (zLanguage) {
            case "german":
                translate.setZielLanguage("german");
                translate.setZielWord(card.getGerman().toLowerCase(Locale.ROOT));
                break;
            case "english":
                translate.setZielLanguage("english");
                translate.setZielWord(card.getEnglish().toLowerCase(Locale.ROOT));
                break;
            case "turkish":
                translate.setZielLanguage("turkish");
                translate.setZielWord(card.getTurkish().toLowerCase(Locale.ROOT));
                break;
            case "spanish":
                translate.setZielLanguage("spanish");
                translate.setZielWord(card.getSpanish().toLowerCase(Locale.ROOT));
                break;
        }
        return translate;
    }
}


