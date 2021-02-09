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
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public String showFormCreate(@ModelAttribute("politis") Salesman salesman) {
        return "salesman/salesmanFormCreate";
    }
    //TO APOPANO EINAI SAN NA EKANA TO PARAKATO
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String showFormCreate(Model model) {
//        model.addAttribute("politis", new Salesman());
//        return "salesman/salesmanFormCreate";
//    }
    

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("politis") Salesman salesman, BindingResult result,RedirectAttributes redirectAttributes) {

        if (result.hasErrors()){
            return "salesman/salesmanFormCreate";
        }
        
        salesmanService.saveSalesman(salesman);
        redirectAttributes.addFlashAttribute("message", "Successfull creation"); 

        return "redirect:/salesman";
    }

    @RequestMapping("/delete/{scode}")
    public String delete(@PathVariable(name = "scode") int scode, RedirectAttributes redirectAttributes) {

        salesmanService.delete(scode);
        
        return "redirect:/salesman";
    }

    @RequestMapping(value = "/update/{scode}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable(name = "scode") int scode, Model model) {      

        Salesman salesman = salesmanService.getSalesman(scode);

        model.addAttribute("politis", salesman);

        return "salesman/salesmanFormUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("politis") Salesman salesman, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()){
            return "salesman/salesmanFormCreate";
        }
        
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
    
//    @ExceptionHandler(Exception.class)
//    public String handleException(RedirectAttributes attributes) {
//        String minima = "General Exception error!!";
//        attributes.addFlashAttribute("message", minima);
//        return "redirect:/salesman";
//    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        String minima = "Could not commit transaction!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }

}
