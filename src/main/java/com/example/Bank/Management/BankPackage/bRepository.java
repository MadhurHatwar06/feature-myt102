package com.example.Bank.Management.BankPackage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bRepository extends CrudRepository<bEntity, Long> {
}
