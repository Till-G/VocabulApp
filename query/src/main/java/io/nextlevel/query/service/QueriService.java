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

    public Iterable<Queri> getAllLanguageAandZ(String aLanguage, String zLanguage){
        Iterable<Queri> list = queriRepository.getQuerisByAusgangLanguageAndZielLanguage(aLanguage, zLanguage);
        return list;
    }

    public Iterable<Queri> query(String aLanguage, String zLanguage, int difficulty){
        Iterable<Queri> list = queriRepository.getQuerisByAusgangLanguageAndZielLanguageAndDifficulty(aLanguage, zLanguage, difficulty);
        return list;
    }

    public Iterable<Card> addCards (Iterable<Card> cardList){
        Iterable<Card> cards = cardRepository.findAll();
        for(Card c : cardList){
            boolean contain = false;
            for(Card cr : cards){
                int cId = c.getId();
                int crId = cr.getId();
                c.setId(0);
                cr.setId(0);
                // contain true if card c exists in entity card
                if(cr.equals(c))
                    contain = true;
                else if(cr.getGerman().equals(c.getGerman())){
                    cr.setId(crId);
                    if(c.getEnglish() != null && cr.getEnglish() == null){
                        cr.setEnglish(c.getEnglish());
                        queriRepository.save(CardToQueri.CardToQuery(cr, ENGLISH, GERMAN));
                        queriRepository.save(CardToQueri.CardToQuery(cr, GERMAN, ENGLISH));
                    }

                    if(c.getTurkish() != null && cr.getTurkish() == null){
                        cr.setTurkish(c.getTurkish());
                        queriRepository.save(CardToQueri.CardToQuery(cr, GERMAN, TURKISH));
                        queriRepository.save(CardToQueri.CardToQuery(cr, TURKISH, GERMAN));
                    }

                    if(c.getSpanish() != null && cr.getSpanish() == null){
                        cr.setSpanish(c.getSpanish());
                        queriRepository.save(CardToQueri.CardToQuery(cr, GERMAN, SPANISH));
                        queriRepository.save(CardToQueri.CardToQuery(cr, SPANISH, GERMAN));
                    }
                    contain = true;
                    cardRepository.save(cr);
                }
                c.setId(cId);
                cr.setId(crId);
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
