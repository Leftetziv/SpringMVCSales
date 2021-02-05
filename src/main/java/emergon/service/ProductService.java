/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import emergon.entity.Product;
import emergon.repository.CustomerRepo;
import emergon.repository.ProductRepo;
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
public class ProductService {
//    private List<Product> products; 
    
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
//        if (products == null) {
//            products = new ArrayList<>();
//            products.add(new Product(1, "p1", 1.2));
//            products.add(new Product(2, "p2", 2.3));
//            products.add(new Product(3, "p3", 3.4));
//        }
//        return products;
    }

    public void addProduct(Product product) {
        productRepo.save(product);
//        products.add(product);
    }

    public void delete(int pcode) {
        productRepo.delete(Product.class, pcode);
//        products = products.stream().filter(p -> p.getPcode()!= pcode).collect(Collectors.toList());
    }

    public Product getProduct(int pcode) {
        return productRepo.find(pcode);
//        return products.stream().filter(p -> p.getPcode() == pcode).findFirst().get();
    }    

    public void update(Product product) {
        productRepo.save(product);
        
//        int indexOf = products.indexOf(product);       
//        products.set(indexOf, product);
    }
}
