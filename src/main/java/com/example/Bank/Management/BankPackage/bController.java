package com.example.Bank.Management.BankPackage;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/")
public class bController {
    @Autowired
    private bService bservice;

    @PostMapping("save")
    public ResponseEntity<bEntity> addBankDetails(@Valid @RequestBody bEntity bentity){
        bEntity saveBank = bservice.addBankDetails(bentity);
        return new ResponseEntity<>(saveBank, HttpStatus.OK);
    }

    @GetMapping("fetch/{bankId}")
    public ResponseEntity<bEntity> getBankDetails(@Valid @PathVariable Long bankId){
        if (bservice.getBankDetails(bankId) != null) {
            return new ResponseEntity<>(bservice.getBankDetails(bankId),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("update/{bankId}")
    public ResponseEntity<bEntity> updateBankDetails(@Valid @PathVariable Long bankId,
                                                     @RequestBody bEntity newBEntity) {
        return new ResponseEntity<>(bservice.updateBankDetails(newBEntity,bankId),HttpStatus.OK);
    }

    @DeleteMapping("delete/{bankId}")
    public ResponseEntity<HttpStatus> deleteBankDetails(@PathVariable Long bankId){
        bservice.deleteBankDetails(bankId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
