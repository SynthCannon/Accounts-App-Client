package com.angular.accounts.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolAccountController {
    private AccountRepository repository;

    public CoolAccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cool-account")
    public Collection<Account> coolAccounts() {
        return repository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Account account) {
        return !account.getName().equals("Woody") &&
                !account.getName().equals("Andy") &&
                !account.getName().equals("Sid") &&
                !account.getName().equals("Yugi Moto");
    }
}