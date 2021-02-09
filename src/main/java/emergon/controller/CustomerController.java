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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Leyteris
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;   

    
    //einai san na grafo @RequestMapping("/",  method = RequestMethod.GET)
    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView) {               
        
        modelAndView.addObject("listOfCustomers", customerService.getCustomers());
        modelAndView.setViewName("customer/customerList");

        return modelAndView;
    }
    
    //gia get yparxei kai to @GetMapping
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showFormCreate() {
        return "customer/customerFormCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, RedirectAttributes redirectAttributes) {

        customerService.addCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Successfull creation"); //minima gia na emfanisei sto proto load tou jsp me tous customers

        //kano redirect allios meta to submit tis formas, an patiso redirect kanei pali post giati einai to teleutaio request pou ekane o xristis
        return "redirect:/customer";
    }

    @RequestMapping("/delete/{ccode}")
    public String delete(@PathVariable(name = "ccode") int ccode, Model model) {

        customerService.delete(ccode);

        return "redirect:/customer";
    }

    @RequestMapping(value = "/update/{ccode}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable(name = "ccode") int ccode, Model model) {        //an to estelna san parametro to eperna san @RequestParam

        Customer customer = customerService.getCustomer(ccode);

        model.addAttribute("customerToEdit", customer);

        return "customer/customerFormUpdate";
    }

    //gia post yparxei kai to @GetMapping
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Customer customer, RedirectAttributes redirectAttributes) {

        customerService.update(customer);

        redirectAttributes.addFlashAttribute("message", "Successfull updating"); //minima gia na emfanisei sto proto load tou jsp me tous customers

        return "redirect:/customer";
    }

}
