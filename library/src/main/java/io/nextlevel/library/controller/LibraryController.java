package io.nextlevel.library.controller;

import io.nextlevel.library.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint library
 */
@RestController
@RequestMapping("/library")
public class LibraryController {

    /**
     * Service implementiert Logik
     */
    private LibraryService libService = new LibraryService();

    /**
     * Sub-Endpoint hello
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return libService.getHelloMessage();
    }

    @GetMapping()
    public String library() { return libService.getLibrary();}
}
