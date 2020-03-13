package com.example.annotation.controller;


import com.example.annotation.aop.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/sourceA")
    public String sourceA() {
        return "you are accessing sourceA...";
    }

    @LoginRequired
    @GetMapping("/sourceB")
    public String sourceB() {
        return "you are accessing sourceB...";
    }

    @MyLog
    @GetMapping("/sourceC/{sourceOne}/{sourceTwo}")
    public String sourceC(@PathVariable("sourceOne") String sourceOne,
                          @PathVariable("sourceTwo") String sourceTwo) {
        return "you are accessing sourceC...";
    }
}
