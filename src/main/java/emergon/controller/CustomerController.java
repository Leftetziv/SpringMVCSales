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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showFormCreate() {
        return "customerFormCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, Model model) {

        customerService.addCustomer(customer);

        model.addAttribute("listOfCustomers", customerService.getCustomers());

        return "customerList";
    }

    @RequestMapping("/delete/{ccode}")
    public String delete(@PathVariable(name = "ccode") int ccode, Model model) {
        
        customerService.delete(ccode);

        model.addAttribute("listOfCustomers", customerService.getCustomers());
        
        return "customerList";
    }

    
    @RequestMapping(value = "/update/{ccode}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable(name = "ccode") int ccode, Model model) {
                
        Customer customer = customerService.getCustomer(ccode);
        
        model.addAttribute("customerToEdit", customer);
        
        return "customerFormUpdate";
    }
    
    @RequestMapping(value = "/update/{ccode}", method = RequestMethod.POST)
    public String update(@PathVariable(name = "ccode") int ccode, Customer customer, Model model) {
        
        customerService.update(customer);      

        model.addAttribute("listOfCustomers", customerService.getCustomers());

        return "customerList";
    }
    
}
