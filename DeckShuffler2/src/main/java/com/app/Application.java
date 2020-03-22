package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.app.deckshuffler.DeckController;

@SpringBootApplication
@ComponentScan(basePackages = "com.app.deckshuffler")
public class Application {

    public static void main(String [] args){
        SpringApplication.run(Application.class,args);
    }
}
