/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Leyteris
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView) {

        modelAndView.addObject("listOfCustomers", customerService.getCustomers());
        modelAndView.setViewName("customerList");
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm() {
        return "customerForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, Model model) {//@ModelAttribute("customer") 
        List<Customer> customers = customerService.getCustomers();
        customers.add(customer);
        
        model.addAttribute("listOfCustomers", customers);
        
        System.out.println(customer);
        return "customerList";
    }
    
}
