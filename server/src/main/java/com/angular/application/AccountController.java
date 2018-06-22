package com.angular.application;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;

@RestController
class AccountController {
    private AccountRepository repository;

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Account> Accounts() {
        return new ArrayList<>(repository.findAll());
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}