package io.nextlevel.frontend.controller;

import io.nextlevel.frontend.common.Card;
import io.nextlevel.frontend.common.Queri;
import io.nextlevel.frontend.common.Translate;
import io.nextlevel.frontend.service.FrontendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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


    @GetMapping("/card/library/{language}")
    @CrossOrigin(origins = "*")
    public String getLibraryCards(@PathVariable("language") String language) throws JSONException {
        return service.getAllCards(language);
    }

    @GetMapping("/card/{id}")
    @CrossOrigin(origins = "*")
    public String getCard(@PathVariable("id") int id) throws JSONException {
        return service.getCard(id);
    }

    @PutMapping("/card/{id}")
    @CrossOrigin(origins = "*")
    public void modifyCard(@PathVariable("id") int id, @RequestBody Card card){
        service.modifyCard(id, card);
    }

    @DeleteMapping("/card/{id}")
    @CrossOrigin(origins = "*")
    public void deleteCard(@PathVariable("id") int id){
        service.deleteCard(id);
    }

    @PostMapping("/card/add")
    @CrossOrigin(origins = "*")
    public String addCard(@RequestBody Card card) throws JSONException {
        return service.addCard(card);
    }


    @GetMapping("query/{aLanguage}/{zLanguage}")
    @CrossOrigin(origins = "*")
    public String getAllLanguageAandZ(@PathVariable("aLanguage") String aLanguage,
                                               @PathVariable("zLanguage") String zLanguage) throws JSONException {
        return service.getAllLanguageAandZ(aLanguage, zLanguage);
    }
    @GetMapping("query/{aLanguage}/{zLanguage}/{difficulty}")
    @CrossOrigin(origins = "*")
    public String query(@PathVariable("aLanguage") String aLanguage,
                                 @PathVariable("zLanguage") String zLanguage,
                                 @PathVariable("difficulty") int difficulty) throws JSONException {
        return service.query(aLanguage, zLanguage, difficulty);
    }

    @GetMapping("translate/{alanguage}/{zlanguage}/{word}")
    @CrossOrigin(origins = "*")
    public String translate(@PathVariable("alanguage") String alanguage,
                               @PathVariable("zlanguage") String zlanguage,
                               @PathVariable("word") String word) throws JSONException {
        return service.translate(alanguage, zlanguage, word);
    }


}
