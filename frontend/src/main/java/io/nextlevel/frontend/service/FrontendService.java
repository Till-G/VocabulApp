package io.nextlevel.frontend.service;

import io.nextlevel.frontend.common.Card;
import io.nextlevel.frontend.common.Queri;
import io.nextlevel.frontend.common.Translate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class FrontendService {
    @Autowired
    private RestTemplate template;

    public String test(){
        return template.getForObject("http://GATEWAY-SERVICE/card/pushAllToQuery", String.class);
    }

    public Iterable<Card> getAllCards(String language){
        return template.getForObject("http://GATEWAY-SERVICE/card/library/" +language, Iterable.class);
    }

    public Card getCard(int id){
        return template.getForObject("http://GATEWAY-SERVICE/card/" +id, Card.class);
    }

    public void modifyCard(int id){
        template.put("http://GATEWAY-SERVICE/card/" +id, Card.class);
    }

    public void deleteCard(int id){
        template.delete("http://GATEWAY-SERVICE/card/" +id);
        log.info("Deleted Card with id: " + id);
    }

    public Card addCard(Card card){
        return template.postForObject("http://GATEWAY-SERVICE/card/add", card, Card.class);
    }

    public Iterable<Queri> getAllLanguageAandZ(String aLanguage, String zLanguage){
        return template.getForObject("http://GATEWAY-SERVICE/query/" + aLanguage + "/" +zLanguage, Iterable.class);
    }

    public Iterable<Queri> query(String aLanguage, String zLanguage, int difficulty){
        return template.getForObject("http://GATEWAY-SERVICE/query/" + aLanguage + "/" + zLanguage + "/" + difficulty, Iterable.class);
    }

    public Translate translate(String aLanguage, String zLanguage, String word){
        return template.getForObject("http://GATEWAY-SERVICE/translate/" + aLanguage + "/" + zLanguage + "/" + word, Translate.class);
    }


}
