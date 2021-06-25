package io.nextlevel.frontend.service;

import io.nextlevel.frontend.common.Card;
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


}
