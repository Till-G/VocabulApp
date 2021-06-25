package io.nextlevel.frontend.controller;

import io.nextlevel.frontend.common.Card;
import io.nextlevel.frontend.service.FrontendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FrontendController {
    @Autowired
    FrontendService service;


    @GetMapping("/test")
    public String test(){
        return service.test();
    }

    @GetMapping("/card/library/{language}")
    public Iterable<Card> getAllCards(@PathVariable("language") String language){
        return service.getAllCards(language);
    }
}
