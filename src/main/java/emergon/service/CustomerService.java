/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leyteris
 */
@Service
public class CustomerService {

    private List<Customer> customers; 

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
            customers.add(new Customer(1, "fou"));
            customers.add(new Customer(2, "bar"));
            customers.add(new Customer(3, "foubar"));
        }
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void delete(int ccode) {
        customers = customers.stream().filter(c -> c.getCcode() != ccode).collect(Collectors.toList());
    }

    public void update(int ccode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
