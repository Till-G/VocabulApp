package io.nextlevel.translate.controller;

import io.nextlevel.translate.common.Card;
import io.nextlevel.translate.entity.Translate;
import io.nextlevel.translate.service.TranslateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Endpoint translate
 */
@RestController
@RequestMapping("/translate")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class TranslateController {
    /**
     * Service implementiert Logik
     */
    @Autowired
    private TranslateService service;

    @GetMapping()
    public Iterable<Translate> findAll(){
        return service.findAll();
    }

    /**
     * translates a word in a specific language to another one
     * @param alanguage ausgangs-language
     * @param zlanguage ziel-language
     * @param word searched wordf
     * @return
     */
    @GetMapping("/{alanguage}/{zlanguage}/{word}")
    public Translate translate(@PathVariable("alanguage") String alanguage,
                               @PathVariable("zlanguage") String zlanguage,
                               @PathVariable("word") String word){
        return service.translate(alanguage, zlanguage, word);
    }




}
