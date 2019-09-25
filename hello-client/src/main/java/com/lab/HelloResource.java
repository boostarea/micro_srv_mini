package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Author chenrong
 * @Date 2019-09-24 16:38
 **/
@RestController
@RequestMapping("rest/hello/client")
public class HelloResource {

    @Value("${server.port}")
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String exec() {
        String url = "http://hello-server/rest/hello/server";
        return restTemplate.getForObject(url, String.class) + " including client(on port " + port + ").";
    }
}
