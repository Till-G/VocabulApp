package io.nextlevel.query.controller;

import io.nextlevel.query.service.QueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class QueryController {
    private QueryService qryService = new QueryService();

    @GetMapping()
    public String query(){
        return qryService.getQuery();
    }
}
