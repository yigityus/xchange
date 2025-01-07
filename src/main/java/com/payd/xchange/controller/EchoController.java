package com.payd.xchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EchoController {
    @GetMapping("/echo")
    public EchoLog echo(@RequestParam String name) {
        return new EchoLog(LocalDateTime.now(), name);
    }

    record EchoLog(LocalDateTime instant, String name) {}
}
