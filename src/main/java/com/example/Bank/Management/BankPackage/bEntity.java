package com.example.Bank.Management.BankPackage;

import com.example.Bank.Management.CustomerPackage.CustomerDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class bEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bankId;

    @NotEmpty(message = "Bank name cannot be empty")
    private String bankName;

    @NotEmpty(message = "Branch cannot be empty")
    private String branch;

    @Size(min = 10, max = 50, message = "Address should have a length between 10 and 100 characters.")
    private String address;

    @Min(value = 10, message = "IFSC code cannot be less than 10 digits")
    private Integer ifscCode;

    public bEntity(long bankId, String bankName, String branch, String address, Integer ifscCode, List<CustomerDetails> customerDetails) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.branch = branch;
        this.address = address;
        this.ifscCode = ifscCode;
        this.customerDetails = customerDetails;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "bankDetails", cascade = CascadeType.ALL)
    private List<CustomerDetails> customerDetails = new ArrayList<>();

    public List<CustomerDetails> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetails> customerDetails) {
        this.customerDetails = customerDetails;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(Integer ifscCode) {
        this.ifscCode = ifscCode;
    }
}
