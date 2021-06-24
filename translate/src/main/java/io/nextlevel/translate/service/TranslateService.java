package io.nextlevel.translate.service;

import io.nextlevel.translate.common.Card;
import io.nextlevel.translate.common.CardToTranslate;
import io.nextlevel.translate.entity.Translate;
import io.nextlevel.translate.repository.TranslateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class TranslateService {
    @Autowired
    private RestTemplate template;
    @Autowired
    private TranslateRepository repository;


    public Translate translate(String alanguage, String zlanguage, String word){
        alanguage = alanguage.toLowerCase(Locale.ROOT);
        zlanguage = zlanguage.toLowerCase(Locale.ROOT);
        word = word.toLowerCase(Locale.ROOT);
        Translate translateReturn = new Translate();
        translateReturn =  repository.getTranslateByAusgangLanguageAndZielLanguageAndAusgangWord(alanguage, zlanguage, word);
        if(translateReturn == null){
            Card cardResponse = template.getForObject("http://GATEWAY-SERVICE/card/"+alanguage+"/"+word, Card.class);
            translateReturn = CardToTranslate.CardToTranslate(cardResponse, alanguage, zlanguage);
            repository.save(translateReturn);
        }
        return translateReturn;
    }

    public Iterable<Translate> findAll(){
        return repository.findAll();
    }



}
