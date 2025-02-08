package com.example.Bank.Management.CustomerPackage;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailRepo extends CrudRepository<CustomerDetails, Long> {

}
