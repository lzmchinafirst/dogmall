package org.singledog.dogmall.back.adapter.web;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Async
    public String test() {
        return "succes" +
                "s";
    }
}
