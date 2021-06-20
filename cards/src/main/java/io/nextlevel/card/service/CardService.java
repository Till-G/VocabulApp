package io.nextlevel.card.service;

import io.nextlevel.card.entity.Card;
import io.nextlevel.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class CardService {
    private final CardRepository repository;

    public Iterable<Card> getAllCardsForLanguage(String language){
        language = language.toLowerCase(Locale.ROOT);
        Iterable<Card> list = null ;
        switch(language){
            case "german":
                list = repository.findAllByGermanIsNotNull();
                break;
            case "english":
                list = repository.findAllByEnglishIsNotNull();
                break;
            case "turkish":
                list = repository.findAllByTurkishIsNotNull();
                break;
            case "spanish":
                list = repository.findAllBySpanishIsNotNull();
                break;
            default:
                log.info("Something went wrooooong");
        }
        return list;
    }

    public Card addCard(Card card){
        log.info("Adding Card: " + card);
        return repository.save(card);
    }
    public Iterable<Card> findAll(){
        log.info("findAll-Method to find all Cards");
        return repository.findAll();
    }

    public Card findById(int id){
        assert(id >= 0);
        log.info("Find Card by ID " + id);
        Card c;
        c = repository.findById(id);
        log.info("Found Card: " + c.toString());
        return c;
    }

    public Card update(Card card){
        log.info("Updated Card: "+ card.toString());
        return repository.save(card);
    }

    public void delete(int id){
        log.info("Deleted Card with id: "+ id);
        repository.deleteById(id);
    }

}
