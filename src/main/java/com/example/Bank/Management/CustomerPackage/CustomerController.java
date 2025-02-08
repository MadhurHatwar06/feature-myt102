package com.example.Bank.Management.CustomerPackage;

import com.example.Bank.Management.BankPackage.bRepository;
import com.example.Bank.Management.account.accService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerDetailRepo customerDetailRepo;

    @Autowired
    private custServices custService;

    @Autowired
    private bRepository bankDetailsRepository;

    @PostMapping("save")
    public ResponseEntity<CustomerDetails> addCustomerDetails(@RequestBody CustomerDetails customerDetails){
        CustomerDetails saveCustomer = custService.addCustomerDetails(customerDetails);

        return new ResponseEntity<>(saveCustomer,HttpStatus.OK);
    }

    @GetMapping("fetch/{custId}")
    public ResponseEntity<CustomerDetails> getCustomerDetails(@PathVariable Long custId){
        if (custService.getCustomerDetails(custId) != null) {
            return new ResponseEntity<>(custService.getCustomerDetails(custId),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("update/{custId}")
    public ResponseEntity<CustomerDetails> updateCustomerDetails(@PathVariable Long custId,
                                                                 @RequestBody CustomerDetails newCustomerDetails){
        return new ResponseEntity<>(custService.updateCustomerDetails(newCustomerDetails,custId), HttpStatus.OK);
    }


    @DeleteMapping("delete/{custId}")
    public ResponseEntity<HttpStatus> deleteCustomerDetails(@PathVariable Long custId){
        custService.deleteCustomerDetails(custId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //assigning bank
//    @PutMapping("{custId}/bank/{bankId}")
//    public ResponseEntity<CustomerDetails> assignBankToCustomer(@PathVariable Long custId, @PathVariable Long bankId){
//
//        List<BankDetails>  setBank = null;
//        CustomerDetails updateCustomer = customerDetailRepo.findById(custId).get();
//        //BankDetails bankDetails = bankDetailsRepository.findById(bankId).get();
//
//        setBank = updateCustomer.getBankDetails();
//       // setBank.add(bankDetails);
//        updateCustomer.setBankDetails(setBank);
//
//        customerDetailRepo.save(updateCustomer);
//        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
//    }
}
