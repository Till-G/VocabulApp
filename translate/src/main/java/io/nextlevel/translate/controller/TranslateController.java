package io.nextlevel.translate.controller;

import io.nextlevel.translate.service.TranslateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint translate
 */
@RestController
@RequestMapping("/translate")
public class TranslateController {

    /**
     * Service implementiert Logik
     */
    private TranslateService trnsService = new TranslateService();

    /**
     * Sub-Endpoint hello
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return trnsService.getHelloMessage();
    }
}
