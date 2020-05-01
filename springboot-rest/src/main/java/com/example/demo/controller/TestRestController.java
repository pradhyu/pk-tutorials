package com.example.demo.controller;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/testing")
public class TestRestController {


    @ResponseBody
    @GetMapping(value="/timeout")
    public Integer timeout(@RequestParam(value="seconds") int seconds) throws InterruptedException {

        for(int i=1 ; i<= seconds/1000; i++){
            Thread.sleep(1000) ;
            System.out.println(i + " Seconds passed");
        }
       return seconds;
    }

}
