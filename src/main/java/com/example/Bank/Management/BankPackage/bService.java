package com.example.Bank.Management.BankPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class bService {

    @Autowired
    private bRepository brepository;

    public  bEntity addBankDetails(bEntity bank) {
        bEntity saveBank = brepository.save(bank);
        return saveBank;
    }

    public bEntity getBankDetails(long Id) {
        Optional<bEntity> fetchBank = brepository.findById(Id);
        if (fetchBank.isPresent()) {
            return fetchBank.get();
        } else {
            return null;
        }
    }

    public bEntity updateBankDetails(bEntity newBank, long bankId) {
        Optional<bEntity> fetchBank = brepository.findById(bankId);
        if (fetchBank.isPresent()) {
            bEntity updateBank = fetchBank.get();
            updateBank.setBankName(newBank.getBankName());
            updateBank.setBranch(newBank.getBranch());
            updateBank.setAddress(newBank.getAddress());
            updateBank.setIfscCode(newBank.getIfscCode());
            bEntity bankObj = brepository.save(updateBank);
            return bankObj;
        } else {
            return null;
        }
    }

    public HttpStatus deleteBankDetails(long bankId) {
        brepository.deleteById(bankId);
        return HttpStatus.OK;
    }
}
