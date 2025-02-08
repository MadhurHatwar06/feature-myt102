package com.example.Bank.Management.CustomerPackage;

import com.example.Bank.Management.account.Entity;
import com.example.Bank.Management.BankPackage.bEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@jakarta.persistence.Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custId;


    @ManyToMany
    @JoinTable(name = "customer_details_bank_details", joinColumns = @JoinColumn(name = "customer_details_cust_id"),
    inverseJoinColumns = @JoinColumn(name = "bank_details_bank_id"))
    private List<bEntity> bankDetails = new ArrayList<>();


    private String custName;

    private String custPhoneNo;

    private String custPanNo;

    private String custEmail;

    private String custAddress;

    private  String Branch;

    private  String City;

    private  String State;

    @ManyToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Entity> accounts = new ArrayList<>();

    public List<bEntity> getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(List<bEntity> bankDetails) {
        this.bankDetails = bankDetails;
    }


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustPhoneNo() {
        return custPhoneNo;
    }

    public void setCustPhoneNo(String custPhoneNo) {
        this.custPhoneNo = custPhoneNo;
    }

    public String getCustPanNo() {
        return custPanNo;
    }

    public void setCustPanNo(String custPanNo) {
        this.custPanNo = custPanNo;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
    @Override
    public String toString() {
        return "CustomerDetails{" +
                "custId=" + custId +
                ", bankDetails=" + bankDetails +
                ", custName='" + custName + '\'' +
                ", custPhoneNo='" + custPhoneNo + '\'' +
                ", custPanNo='" + custPanNo + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", Branch='" + Branch + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", accounts=" + accounts +
                '}';
    }

}
