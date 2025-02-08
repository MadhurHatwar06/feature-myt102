package com.example.Bank.Management.account;

import com.example.Bank.Management.CustomerPackage.CustomerDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class accService {

    @Autowired
    private Repository repository;

    @Autowired
    private CustomerDetailRepo custRepo;

    public Entity addAccount(Entity accounts) {
        long custId;
        custId = accounts.getCustomer().get(0).getCustId();
        if (custRepo.findById(custId).isPresent()) {
            Entity saveAccount = repository.save(accounts);
            return saveAccount;
        }
        else {
            throw new RuntimeException("Customer Details Not Found");
        }
    }

    public Entity getAccount(@PathVariable Long accId) {
        Optional<Entity> fetchAccount = repository.findById(accId);
        if (fetchAccount.isPresent()) {
            return fetchAccount.get();
        } else {
            return null;
        }
    }

    public Entity updateAccount(Entity newAccount, long accId) {
        Optional<Entity> fetchAccount = repository.findById(accId);
        if (fetchAccount.isPresent()){
            Entity updateAccount = fetchAccount.get();
            updateAccount.setAccountType(newAccount.getAccountType());
            updateAccount.setAccountStatus(newAccount.getAccountStatus());
            Entity accountObj = repository.save(updateAccount);
            return accountObj;
        }
        else {
            return null;
        }
    }

    public HttpStatus deleteAccount(long accId) {
        repository.deleteById(accId);
        return HttpStatus.OK;
    }
}
