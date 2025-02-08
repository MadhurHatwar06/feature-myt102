package com.example.Bank.Management.account;
import com.example.Bank.Management.CustomerPackage.CustomerDetails;
import com.example.Bank.Management.TransactionPackage.Transactions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@jakarta.persistence.Entity
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;

    private String accountType;

    private String accountStatus;

    @ManyToMany
    @JoinTable(name = "accounts_customer", joinColumns = @JoinColumn(name = "accounts_account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_cust_id"))
    private List<CustomerDetails> customer = new ArrayList<>();

    @ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transactions> transactions = new ArrayList<>();

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }


    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<CustomerDetails> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerDetails> customer) {
        this.customer = customer;
    }
}
