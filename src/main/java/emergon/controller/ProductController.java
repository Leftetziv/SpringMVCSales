/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.entity.Product;
import emergon.service.CustomerService;
import emergon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Leyteris
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping
    public ModelAndView showProducts(ModelAndView modelAndView) {

        modelAndView.addObject("listOfProducts", productService.getProducts());
        modelAndView.setViewName("productList");

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showFormCreate() {
        return "productFormCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Product product, Model model) {

        productService.addProduct(product);

        model.addAttribute("listOfProducts", productService.getProducts());

        return "productList";
    }

    @RequestMapping("/delete/{pcode}")
    public String delete(@PathVariable(name = "pcode") int pcode, Model model) {
        
        productService.delete(pcode);

        model.addAttribute("listOfProducts", productService.getProducts());
        
        return "productList";
    }

    
    @RequestMapping(value = "/update/{pcode}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable(name = "pcode") int pcode, Model model) {
                
        Product product = productService.getProduct(pcode);
        
        model.addAttribute("productToEdit", product);
        
        return "productFormUpdate";
    }
    
    @RequestMapping(value = "/update/{pcode}", method = RequestMethod.POST)
    public String update(@PathVariable(name = "pcode") int pcode, Product product, Model model) {
        
        productService.update(product);      

        model.addAttribute("listOfProducts", productService.getProducts());

        return "productList";
    }
}
