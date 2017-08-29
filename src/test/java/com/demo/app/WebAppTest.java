package com.demo.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebAppTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingPageLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Welcome to the Rectangle calculator");
    }
    
    @Test
    public void dataPageLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/data.html",
                String.class)).contains("Enter your rectangle information");
    }
    
    @Test
    public void rectanglePageLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/rectangle",
                String.class)).contains("Results");
    }
        
}