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
                translate.setALanguage("german");
                translate.setAWord(card.getGerman());
                break;
            case "english":
                translate.setALanguage("english");
                translate.setAWord(card.getEnglish());
                break;
            case "turkish":
                translate.setALanguage("turkish");
                translate.setAWord(card.getTurkish());
                break;
            case "spanish":
                translate.setALanguage("spanish");
                translate.setAWord(card.getSpanish());
                break;
        }
        switch (zLanguage) {
            case "german":
                translate.setZLanguage("german");
                translate.setZWord(card.getGerman());
                break;
            case "english":
                translate.setZLanguage("english");
                translate.setZWord(card.getEnglish());
                break;
            case "turkish":
                translate.setZLanguage("turkish");
                translate.setZWord(card.getTurkish());
                break;
            case "spanish":
                translate.setZLanguage("spanish");
                translate.setZWord(card.getSpanish());
                break;
        }
        return translate;
    }
}


