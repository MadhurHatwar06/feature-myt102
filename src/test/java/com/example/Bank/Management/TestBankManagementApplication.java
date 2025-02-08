package com.example.Bank.Management;

import org.springframework.boot.SpringApplication;

public class TestBankManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(BankManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
