package com.example.Bank.Management.TransactionPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/transaction/")
public class TransactionController {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private tranServices tranService;

    @PostMapping("deposit")
    public ResponseEntity<Transactions> deposit(@RequestBody Transactions transaction){

        Transactions saveTransaction = tranService.deposit(transaction);
        return new ResponseEntity<>(saveTransaction, HttpStatus.OK);
    }

     @GetMapping("fetch/{transId}")
     public ResponseEntity<Transactions> getTransactions(@PathVariable Long transId){
        return  new ResponseEntity<>(tranService.getTransactions(transId),HttpStatus.OK);
     }

     @PostMapping("withdraw/{transId}")
     public ResponseEntity<Transactions> withdraw(@PathVariable Long transId, @RequestBody Transactions transaction) {
        return new ResponseEntity<>(tranService.withdraw(transaction,transId),HttpStatus.OK);
     }


}
