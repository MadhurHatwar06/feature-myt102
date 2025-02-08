package com.example.Bank.Management.TransactionPackage;

import com.example.Bank.Management.account.Entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@jakarta.persistence.Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transId;

    private String transactionType;

    private String transactionStatus;

    private double Amount;


    private Date transactionDate;

    @ManyToMany
    @JoinTable(name = "transactions_accounts", joinColumns = @JoinColumn(name = "transactions_trans_id"),
            inverseJoinColumns = @JoinColumn(name = "accounts_account_id"))
    private List<Entity> accounts = new ArrayList<>();

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
        this.transId = transId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<Entity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Entity> accounts) {
        this.accounts = accounts;
    }
}
