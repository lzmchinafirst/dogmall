package org.singledog.dogmall.back.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService test;

    @GetMapping("/test")
    public String test() {
        Enhancer enhancer = new Enhancer(

        );
        return test.test();
    }
}
