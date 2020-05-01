package com.example.demo.controller;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/testing")
public class TestRestController {


    @ResponseBody
    @GetMapping(value="/timeout")
    public  int timeout(@RequestParam(value="seconds") int seconds) throws InterruptedException {
       Thread.sleep(seconds) ;
       return seconds;
    }

}
