package io.nextlevel.card.service;

import io.nextlevel.card.entity.Card;
import io.nextlevel.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class CardService {
    private final CardRepository repository;

    public Iterable<Card> getAllCards(){
        return repository.findAll();
    }

    public String addDefaultCard(){
        var c = new Card();
        c.setGerman("Auto");
        c.setEnglish("Car");
        c.setTurkish("Araba");
//        c.setSpanish("");
        repository.save(c);
        log.info("Added Card" + c.toString() + "\nto DB");
        return c.toString();

    }

    public Iterable<Card> getAllCardsForLanguage(String language){
        language = language.toLowerCase(Locale.ROOT);
        Iterable<Card> iter = null ;
        switch(language){
            case "german":
                iter = repository.findAllByGermanIsNotNull();
                break;
            case "english":
                iter = repository.findAllByEnglishIsNotNull();
                break;
            case "turkish":
                iter = repository.findAllByTurkishIsNotNull();
                break;
            case "spanish":
                iter = repository.findAllBySpanishIsNotNull();
                break;
        }
        return iter;
    }

    public Card addCard(Card card){
        return repository.save(card);
    }
    public Iterable<Card> findAll(){
        return repository.findAll();
    }

    public Card findById(int id){
        assert(id >= 0);
        Card c;
        c = repository.findById(id);
        if(c.equals(null))
            c.setId(-1);
        return c;
    }

    public Card update(Card card){
        return repository.save(card);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

}
