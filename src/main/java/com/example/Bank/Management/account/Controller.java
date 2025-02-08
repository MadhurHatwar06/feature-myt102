package com.example.Bank.Management.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/")
public class Controller {

    @Autowired
    private accService accService;

    @PostMapping("save")
    public ResponseEntity<Entity> addAccount(@RequestBody Entity accounts){
    Entity saveAccount = accService.addAccount(accounts);
        return new ResponseEntity<>(saveAccount, HttpStatus.OK);
    }

    @GetMapping("/fetch/{accId}")
    public ResponseEntity<Entity> getAccount(@PathVariable Long accId){
        return new ResponseEntity<>(accService.getAccount(accId),HttpStatus.NOT_FOUND);
    }

    @PostMapping("update/{accId}")
    public ResponseEntity<Entity> updateAccount(@PathVariable Long accId,
                                                @RequestBody Entity newAccount){
        return new ResponseEntity<>(accService.updateAccount(newAccount,accId),HttpStatus.OK);
    }

    @DeleteMapping("delete/{accId}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable Long accId){
        accService.deleteAccount(accId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
