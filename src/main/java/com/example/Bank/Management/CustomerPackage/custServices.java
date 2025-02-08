package com.example.Bank.Management.CustomerPackage;

import com.example.Bank.Management.BankPackage.bEntity;
import com.example.Bank.Management.BankPackage.bRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class custServices {

    @Autowired
    private CustomerDetailRepo customerDetailRepo;
    @Autowired
    private bRepository bankDetailsRepository;

        public CustomerDetails addCustomerDetails(CustomerDetails customerDetails) {
         Long bankId;
        bankId = customerDetails.getBankDetails().get(0).getBankId();
        if (bankDetailsRepository.findById(bankId).isPresent()) {
            CustomerDetails saveCustomer = customerDetailRepo.save(customerDetails);
            return customerDetails;
        }else {

            throw new RuntimeException("Bank Details Not Found");
        }

    }

    public CustomerDetails getCustomerDetails(long custId) {
        Optional<CustomerDetails> getCustomer = customerDetailRepo.findById(custId);
        if (getCustomer.isPresent()) {
            return getCustomer.get();
        }
        else {
            return null;
        }
    }

    public CustomerDetails updateCustomerDetails(CustomerDetails newCustomerDetails, long custId) {
        Optional<CustomerDetails> getCustomer = customerDetailRepo.findById(custId);
        if (getCustomer.isPresent()) {

            CustomerDetails updateCustomer = getCustomer.get();

            updateCustomer.setCustName(newCustomerDetails.getCustName());
            updateCustomer.setCustEmail(newCustomerDetails.getCustEmail());
            updateCustomer.setCustPanNo(newCustomerDetails.getCustPanNo());
            updateCustomer.setCustPhoneNo(newCustomerDetails.getCustPhoneNo());
            updateCustomer.setCustAddress(newCustomerDetails.getCustAddress());
            updateCustomer.setBranch(newCustomerDetails.getBranch());
            updateCustomer.setCity(newCustomerDetails.getCity());
            updateCustomer.setState(newCustomerDetails.getState());
            CustomerDetails custObj = customerDetailRepo.save(updateCustomer);
            return custObj;
        }
        else {
            return null;
        }
    }

    public HttpStatus deleteCustomerDetails(long custId) {
        customerDetailRepo.deleteById(custId);
        return HttpStatus.OK;
    }
}
