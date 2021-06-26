package io.nextlevel.frontend.service;

import io.nextlevel.frontend.common.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class FrontendService {
    @Autowired
    private RestTemplate template;

    public String getAllCards(String language) throws JSONException {
        CardList cardList = template.getForObject("http://GATEWAY-SERVICE/card/library/" +language, CardList.class);
        return cardList.toJSON().toString();
    }

    public String getCard(int id) throws JSONException {
        Card c = template.getForObject("http://GATEWAY-SERVICE/card/" +id, Card.class);
        return c.toJSON().toString();
    }

    public void modifyCard(int id, Card card){
        template.put("http://GATEWAY-SERVICE/card/" +id, card);
    }

    public void deleteCard(int id){
        template.delete("http://GATEWAY-SERVICE/card/" +id);
        log.info("Deleted Card with id: " + id);
    }

    public String addCard(Card card) throws JSONException {
        Card c = template.postForObject("http://GATEWAY-SERVICE/card/add", card, Card.class);
        return c.toJSON().toString();
    }

    public String getAllLanguageAandZ(String aLanguage, String zLanguage) throws JSONException {
        QueriList qList = template.getForObject("http://GATEWAY-SERVICE/query/" + aLanguage + "/" +zLanguage, QueriList.class);
        return qList.toJSON().toString();
    }

    public String query(String aLanguage, String zLanguage, int difficulty) throws JSONException {
        QueriList qList = template.getForObject("http://GATEWAY-SERVICE/query/" + aLanguage + "/" + zLanguage + "/" + difficulty, QueriList.class);
        return qList.toJSON().toString();
    }

    public String translate(String aLanguage, String zLanguage, String word) throws JSONException {
        Translate t = template.getForObject("http://GATEWAY-SERVICE/translate/" + aLanguage + "/" + zLanguage + "/" + word, Translate.class);
        return t.toJSON().toString();
    }


}
