/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import emergon.repository.CustomerRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leyteris
 */
@Transactional
@Service
public class CustomerService {

    private List<Customer> customers; 
    
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
        
//        if (customers == null) {
//            customers = new ArrayList<>();
//            customers.add(new Customer(1, "fou"));
//            customers.add(new Customer(2, "bar"));
//            customers.add(new Customer(3, "foubar"));
//        }
//        return customers;
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
//        customers.add(customer);
    }

    public void delete(int ccode) {
        customerRepo.delete(Customer.class, ccode);
//        customers = customers.stream().filter(c -> c.getCcode() != ccode).collect(Collectors.toList());
    }   

    public Customer getCustomer(int ccode) {
        return customerRepo.find(ccode);
//        return customers.stream().filter(c -> c.getCcode() == ccode).findFirst().get();
    }    

    public void update(Customer customer) {
        customerRepo.save(customer);
        
//        int indexOf = customers.indexOf(customer);    
//        customers.set(indexOf, customer);
    }

}
