package com.angular.application;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    ApplicationRunner init(AccountRepository repository) {
        return args -> {
            String[] fNames = {"Buzz", "Gandalf", "Sid", "Mr Potato", "Rex", "Bo", "Slinky", "Yugi"};
            String[] lNames = {"Lightyear", "The White", "Vicious", "Head", "Raptor", "Peep", "Dog", "Moto"};
            for (int x = 0; x < 8; x++) {
                Account account = new Account(fNames[x], lNames[x]);
                repository.save(account);
            }
            repository.findAll().forEach(System.out::println);
        };
	}

}
