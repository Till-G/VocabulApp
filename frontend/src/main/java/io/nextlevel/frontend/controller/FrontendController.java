package io.nextlevel.frontend.controller;

import io.nextlevel.frontend.common.Card;
import io.nextlevel.frontend.common.Queri;
import io.nextlevel.frontend.common.Translate;
import io.nextlevel.frontend.service.FrontendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class FrontendController {
    @Autowired
    FrontendService service;


    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return service.test();
    }

    @GetMapping("/card/library/{language}")
    @ResponseBody
    public Iterable<Card> getAllCards(@PathVariable("language") String language){
        return service.getAllCards(language);
    }

    @GetMapping("/card/{id}")
    @ResponseBody
    public Card getCard(@PathVariable("id") int id){
        return service.getCard(id);
    }

    @PutMapping("/card/{id}")
    @ResponseBody
    public void modifyCard(@PathVariable("id") int id){
        service.modifyCard(id);
    }

    @DeleteMapping("/card/{id}")
    @ResponseBody
    public void deleteCard(@PathVariable("id") int id){
        service.deleteCard(id);
    }

    @PostMapping("/card/add")
    @ResponseBody
    public Card addCard(@RequestBody Card card){
        return service.addCard(card);
    }


    @GetMapping("query/{aLanguage}/{zLanguage}")
    @ResponseBody
    public Iterable<Queri> getAllLanguageAandZ(@PathVariable("aLanguage") String aLanguage,
                                               @PathVariable("zLanguage") String zLanguage){
        return service.getAllLanguageAandZ(aLanguage, zLanguage);
    }
    @GetMapping("query/{aLanguage}/{zLanguage}/{difficulty}")
    @ResponseBody
    public Iterable<Queri> query(@PathVariable("aLanguage") String aLanguage,
                                 @PathVariable("zLanguage") String zLanguage,
                                 @PathVariable("difficulty") int difficulty){
        return service.query(aLanguage, zLanguage, difficulty);
    }

    @GetMapping("translate/{alanguage}/{zlanguage}/{word}")
    @ResponseBody
    public Translate translate(@PathVariable("alanguage") String alanguage,
                               @PathVariable("zlanguage") String zlanguage,
                               @PathVariable("word") String word){
        return service.translate(alanguage, zlanguage, word);
    }


}
