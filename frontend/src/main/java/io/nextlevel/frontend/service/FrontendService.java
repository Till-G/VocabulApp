package io.nextlevel.frontend.service;

import com.netflix.discovery.converters.Auto;
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



}
