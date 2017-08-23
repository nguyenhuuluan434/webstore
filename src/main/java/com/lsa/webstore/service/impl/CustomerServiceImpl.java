package com.lsa.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsa.webstore.domain.Customer;
import com.lsa.webstore.domain.repository.CustomerRepository;
import com.lsa.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.getAllCustomer();
	}

}
