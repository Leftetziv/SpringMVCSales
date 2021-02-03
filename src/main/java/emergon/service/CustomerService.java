/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leyteris
 */
@Service
public class CustomerService {
    
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"fou"));
        customers.add(new Customer(2,"bar"));
        customers.add(new Customer(3,"foubar"));
        
        return customers;
    }
   
    
}
