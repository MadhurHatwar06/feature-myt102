package com.example.Bank.Management.TransactionPackage;

import com.example.Bank.Management.account.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class tranServices {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private Repository accRepository;

    public Transactions deposit(Transactions transaction) {
        long accountId;
        accountId = transaction.getAccounts().get(0).getAccountId();
        if (accRepository.findById(accountId).isPresent()) {
            Transactions saveTransaction = transactionRepo.save(transaction);
            return saveTransaction;
        }
        else {
            throw new RuntimeException("Account not found");
        }
    }


    public Transactions getTransactions(long transId) {
        Optional<Transactions> getTransaction = transactionRepo.findById(transId);
        if (getTransaction.isPresent()) {
            return getTransaction.get();
        } else {
            return null;
        }
    }
    public Transactions withdraw(Transactions transaction, long Id) {
        Optional<Transactions> getTransaction = transactionRepo.findById(Id);
        double amount = transaction.getAmount();

            if (getTransaction.isPresent()) {
                Transactions withdrawTransaction = getTransaction.get();
                if (withdrawTransaction.getAmount() < amount) {
                    throw new RuntimeException("Insufficient Balance");
                }else {
                    withdrawTransaction.setAmount(withdrawTransaction.getAmount() - amount);
                    withdrawTransaction.setTransactionType(transaction.getTransactionType());
                    withdrawTransaction.setTransactionDate(new Date());
                    transactionRepo.save(withdrawTransaction);
                    return withdrawTransaction;
                }
            } else {
                return null;
            }
    }
}
