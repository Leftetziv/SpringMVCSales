/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.entity.Salesman;
import emergon.service.SalesmanService;
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
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;   

    
    @RequestMapping
    public ModelAndView showSalesmen(ModelAndView modelAndView) {               
        
        modelAndView.addObject("listOfSalesmen", salesmanService.getSalesmen());
        modelAndView.setViewName("salesman/salesmanList");

        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showFormCreate() {
        return "salesman/salesmanFormCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Salesman salesman, RedirectAttributes redirectAttributes) {

        salesmanService.saveSalesman(salesman);
        redirectAttributes.addFlashAttribute("message", "Successfull creation"); 

        return "redirect:/salesman";
    }

    @RequestMapping("/delete/{scode}")
    public String delete(@PathVariable(name = "scode") int scode, RedirectAttributes redirectAttributes) {

        String msg;
        try {
            salesmanService.delete(scode);
            msg = "ok";
        } catch (Exception e) {
            msg = "Error";
        }
        
        redirectAttributes.addFlashAttribute("message", msg); 

        return "redirect:/salesman";
    }

    @RequestMapping(value = "/update/{scode}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable(name = "scode") int scode, Model model) {      

        Salesman customer = salesmanService.getSalesman(scode);

        model.addAttribute("salesmanToEdit", customer);

        return "salesman/salesmanFormUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Salesman salesman, RedirectAttributes redirectAttributes) {

        salesmanService.saveSalesman(salesman);

        redirectAttributes.addFlashAttribute("message", "Successfull updating");

        return "redirect:/salesman";
    }
    
    
    //auti i methodos tha treksei prin apo oles tis methodous ston controller,kai tha kanei diathesimo
    //to listOfCities sta views
    @ModelAttribute(name = "listOfCities") 
    public List<String> getCities() {
        return salesmanService.getCities();
    }

}
