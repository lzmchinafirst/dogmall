package org.singledog.dogmail.back.adapter.web;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class TestService {

    @Async
    public String test() {
        return "succes" +
                "s";
    }
}
