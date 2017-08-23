package com.lsa.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsa.webstore.domain.Customer;

@Repository
public class CustomerRepositoryIpmpl implements com.lsa.webstore.domain.repository.CustomerRepository {

	private List<Customer> listOfCustomer = new ArrayList<Customer>();

	public CustomerRepositoryIpmpl() {
		Customer customer1 = new Customer("1", "A B 1", "182 LDH");
		Customer customer2 = new Customer("2", "A B 2", "183 LDH");
		Customer customer3 = new Customer("3", "A B 3", "184 LDH");
		Customer customer4 = new Customer("4", "A B 4", "185 LDH");
		listOfCustomer.add(customer1);
		listOfCustomer.add(customer2);
		listOfCustomer.add(customer3);
		listOfCustomer.add(customer4);
	}

	@Override
	public List<Customer> getAllCustomer() {

		return listOfCustomer;
	}

}
