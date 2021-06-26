package io.nextlevel.card.service;

import io.nextlevel.card.entity.Card;
import io.nextlevel.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class CardService {
    @Autowired
    private CardRepository repository;
    @Autowired
    private RestTemplate template;

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

    public Card getSpecificCard(String language, String word){
        language = language.toLowerCase(Locale.ROOT);
        word = word.toLowerCase(Locale.ROOT).trim();
        Iterable<Card> list = this.getAllCardsForLanguage(language);
        Card returnCard = new Card();

        switch(language){
            case "german":
                for(Card c : list){
                    if(word.equals(c.getGerman().toLowerCase(Locale.ROOT)))
                        returnCard = c;
                }
                break;
            case "english":
                for(Card c : list){
                    if(word.equals(c.getEnglish().toLowerCase(Locale.ROOT)))
                        returnCard = c;
                }
                break;
            case "turkish":
                for(Card c : list){
                    if(word.equals(c.getTurkish().toLowerCase(Locale.ROOT)))
                        returnCard = c;
                }
                break;
            case "spanish":
                for(Card c : list){
                    if(word.equals(c.getSpanish().toLowerCase(Locale.ROOT)))
                        returnCard = c;
                }
                break;
            default:
                log.info("Something went wrooooong");
        }
        return returnCard;
    }

    public Iterable<Card> pushAllToQuery(){
        Iterable<Card> allCards = repository.findAll();
        log.info("PUSH ALL TO QUERY");
        allCards = template.postForObject("http://GATEWAY-SERVICE/query/addCards", allCards, Iterable.class);
        log.info("PUSHED: " + allCards);
        return allCards;
    }
    public String test(){
        return template.getForObject("http://GATEWAY-SERVICE/query/test", String.class);
    }

    public void addRandom(){
        Card c = new Card(0, "Verkehr", "Auto", "Car", "Araba", null);
        Card d = new Card(0, "Klamotten", "Hose", "Pants", "Pantolon", "Pantolones");
        Card e = new Card(0, "Obst", "Apfel", "Apple", "Elma", null);
        Card f = new Card(0, "Gemuese", "Aubergine", "Eggplant", "Patlican", null);
        repository.save(c);
        repository.save(d);
        repository.save(e);
        repository.save(f);
    }
}
