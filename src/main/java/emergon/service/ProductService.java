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
    
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();

    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void delete(int pcode) {
        productRepo.delete(Product.class, pcode);
    }

    public Product getProduct(int pcode) {
        return productRepo.find(pcode);
    }    

    public void update(Product product) {
        productRepo.save(product);
    }
}
