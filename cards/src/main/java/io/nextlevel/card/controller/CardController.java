package io.nextlevel.card.controller;

import io.nextlevel.card.entity.Card;
import io.nextlevel.card.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

/**
 * Endpoint card
 */
@RestController
@RequestMapping("/card")
@Slf4j
@RequiredArgsConstructor
public class CardController {

    private final CardService service;

    @PostMapping("/add")
    public Card addCard(@RequestBody Card card){
        return service.addCard(card);
    }

    @GetMapping("/library/{language}")
    public Iterable<Card> getAllCardsForLanguage(@PathVariable("language") String language){
        return service.getAllCardsForLanguage(language);
    }
    @GetMapping("/all")
    public Iterable<Card> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Card findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public @ResponseBody Card update(@RequestBody Card card){
        return service.update(card);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id){
        service.delete(id);
    }

    @GetMapping("/{language}/{word}")
    public Card getSpecificCard(@PathVariable("language") String language,
                                @PathVariable("word") String word){
        return service.getSpecificCard(language, word);
    }
    @GetMapping("/pushAllToQuery")
    public Iterable<Card> pushAllToQuery(){
        return service.pushAllToQuery();
    }

    @GetMapping("/test/query")
    public String test(){
        return service.test();
    }



}
