package com.angular.application;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class AccountController {
    private AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Account> Accounts() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/add-account")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addAccount(@RequestBody String account){
        repository.save(new Gson().fromJson(account.substring(0,account.length()-1)
                + ",\"accountNumber\":\"" + Integer.toString(Account.getNextAccNum()) + "\"}",Account.class));
    }

}