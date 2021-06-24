package io.nextlevel.query.service;

import io.nextlevel.query.Entity.Queri;
import io.nextlevel.query.Entity.Card;
import io.nextlevel.query.common.CardToQueri;
import io.nextlevel.query.repository.CardRepository;
import io.nextlevel.query.repository.QueriRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class QueriService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private QueriRepository queriRepository;
    private static final String ENGLISH = "english";
    private static final String GERMAN = "german";
    private static final String TURKISH = "turkish";
    private static final String SPANISH = "spanish";

    public Iterable<Queri> query(String aLanguage, String zLanguage){
        Iterable<Queri> list = queriRepository.findAll();
        return list;
    }

//    public Iterable<Query> test(String aLanguage, String zLanguage, int difficulty){
//        return repository.findAllByALanguageAndZLanguageAndDifficulty(aLanguage, zLanguage, difficulty);
//    }

    public Iterable<Card> addCards (Iterable<Card> cardList){
        Iterable<Card> cards = cardRepository.findAll();
        for(Card c : cardList){
            boolean contain = false;
            for(Card cr : cards){
                // contain true if card c exists in entity card
                contain = (cr.getEnglish().equals(c.getEnglish())||
                        cr.getGerman().equals(c.getGerman())||
                        cr.getSpanish().equals(c.getSpanish())||
                        cr.getEnglish().equals(c.getEnglish()));
            }
            if(!contain) {
                cardRepository.save(c);
                if (c.getEnglish() != null) {
                    if (c.getGerman() != null) {
                        queriRepository.save(CardToQueri.CardToQuery(c, ENGLISH, GERMAN));
                        queriRepository.save(CardToQueri.CardToQuery(c, GERMAN, ENGLISH));
                    }
                    if (c.getTurkish() != null) {
                        queriRepository.save(CardToQueri.CardToQuery(c, ENGLISH, TURKISH));
                        queriRepository.save(CardToQueri.CardToQuery(c, TURKISH, ENGLISH));
                    }
                    if (c.getSpanish() != null) {
                        queriRepository.save(CardToQueri.CardToQuery(c, ENGLISH, SPANISH));
                        queriRepository.save(CardToQueri.CardToQuery(c, SPANISH, ENGLISH));
                    }
                }
                if (c.getGerman() != null) {
                    if (c.getTurkish() != null) {
                        queriRepository.save(CardToQueri.CardToQuery(c, GERMAN, TURKISH));
                        queriRepository.save(CardToQueri.CardToQuery(c, TURKISH, GERMAN));
                    }
                    if (c.getSpanish() != null) {
                        queriRepository.save(CardToQueri.CardToQuery(c, GERMAN, SPANISH));
                        queriRepository.save(CardToQueri.CardToQuery(c, SPANISH, GERMAN));
                    }
                }
                if (c.getTurkish() != null) {
                    if (c.getSpanish() != null) {
                        queriRepository.save(CardToQueri.CardToQuery(c, TURKISH, SPANISH));
                        queriRepository.save(CardToQueri.CardToQuery(c, SPANISH, TURKISH));
                    }
                }
            }
        }
        return cardList;
    }
}
