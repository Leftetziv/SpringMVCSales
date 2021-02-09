/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Salesman;
import emergon.repository.SalesmanRepo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leyteris
 */
@Transactional //xrisimopoiei to bean HibernateTransactionManager apo to DatabaseConfig, gia na min xreiazete na rythmizo ego ta transaxtions
@Service
public class SalesmanService {
    
    @Autowired
    private SalesmanRepo salesmanRepo;

    public List<Salesman> getSalesmen() {
        return salesmanRepo.findAll();       
    }

    public void saveSalesman(Salesman salesman) {
        salesmanRepo.save(salesman);
    }

    public void delete(int id) {       
        salesmanRepo.delete(Salesman.class, id);
    }   

    public Salesman getSalesman(int id) {
        return salesmanRepo.findById(id);
    }    

    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        cities.add("Athens");
        cities.add("Patra");
        cities.add("Irakleio");
        cities.add("metamo");
        
        return cities;
    }

}
