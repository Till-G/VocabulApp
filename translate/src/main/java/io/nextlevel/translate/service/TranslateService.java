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

@Service
@Slf4j
@AllArgsConstructor
public class TranslateService {
    @Autowired
    private final RestTemplate template;
    @Autowired
    private final TranslateRepository repository;


    public Translate translate(String alanguage, String zlanguage, String word){
        Translate translateReturn = new Translate();
        translateReturn =  repository.findTranslateByALanguageAndZLanguageAndAWord(alanguage, zlanguage, word);
        if(translateReturn.getZWord().isEmpty()){
            Card cardResponse = template.getForObject("http://CARD-SERVICE/"+alanguage+"/"+word, Card.class);
            translateReturn = CardToTranslate.CardToTranslate(cardResponse, alanguage, zlanguage);
            repository.save(translateReturn);
        }
        return translateReturn;
    }

    public Iterable<Translate> findAll(){
        return repository.findAll();
    }



}
