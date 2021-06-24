package io.nextlevel.frontend.controller;

import io.nextlevel.frontend.service.FrontendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@Controller
public class FrontendController {
    @Autowired
    FrontendService service;
    @GetMapping("/test")
    public String test(){
        return service.test();
    }
}
