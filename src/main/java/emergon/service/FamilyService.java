/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.repository.FamilyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leyteris
 */
@Transactional
@Service
public class FamilyService {
    
    @Autowired
    private FamilyRepo familyRepo;

    public List<Family> getSalesmen() {
        return familyRepo.findAll();       
    }

    public void saveFamily(Family family) {
        familyRepo.save(family);
    }

    public void delete(int id) {       
        familyRepo.delete(Family.class, id);
    }   

    public Family getFamily(int id) {
        return familyRepo.findById(id);
    }  

    public List<Family> findBySalesman(Salesman salesman) {
        return familyRepo.findBySalesman(salesman);
    }
}
