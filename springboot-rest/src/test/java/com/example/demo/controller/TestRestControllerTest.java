package com.example.demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
class TestRestControllerTest {
    @Autowired
    RestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    void testTimeout() throws InterruptedException, MalformedURLException {
        try {
            ResponseEntity<Integer> result = restTemplate.getForEntity("http://localhost:" + port + "/testing/timeout?seconds=10000", Integer.class);
            // should time out error
        }
        catch(ResourceAccessException rae){

        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme