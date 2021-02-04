/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import emergon.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leyteris
 */
@Service
public class ProductService {
    private List<Product> products; 

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
            products.add(new Product(1, "p1", 1.2));
            products.add(new Product(2, "p2", 2.3));
            products.add(new Product(3, "p3", 3.4));
        }
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void delete(int ccode) {
        products = products.stream().filter(p -> p.getPcode()!= ccode).collect(Collectors.toList());
    }

    public Product getProduct(int ccode) {
        return products.stream().filter(p -> p.getPcode() == ccode).findFirst().get();
    }    

    public void update(Product product) {
        int indexOf = products.indexOf(product);
        
        products.set(indexOf, product);
    }
}
