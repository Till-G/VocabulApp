package io.nextlevel.query.controller;

import io.nextlevel.query.Entity.Queri;
import io.nextlevel.query.Entity.Card;
import io.nextlevel.query.service.QueriService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/query")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class QueriController {
    @Autowired
    private QueriService service;

    @GetMapping("/{aLanguage}/{zLanguage}")
    public Iterable<Queri> getAllLanguageAandZ(@PathVariable("aLanguage") String aLanguage,
                                               @PathVariable("zLanguage") String zLanguage){
        return service.getAllLanguageAandZ(aLanguage, zLanguage);
    }
    @GetMapping("/{aLanguage}/{zLanguage}/{difficulty}")
    public Iterable<Queri> query(@PathVariable("aLanguage") String aLanguage,
                                @PathVariable("zLanguage") String zLanguage,
                                @PathVariable("difficulty") int difficulty){
        return service.query(aLanguage, zLanguage, difficulty);
    }
    @PostMapping("/addCards")
    public Iterable<Card> addCards(@RequestBody Iterable<Card> cardList){
        log.info("cardList arrived: " + cardList.toString());
        return service.addCards(cardList);
    }
    @GetMapping("/test")
    public String testy(){
        return "COOL";
    }


}
