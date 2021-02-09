/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Family;
import emergon.entity.Salesman;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leyteris
 */
@Repository
public class FamilyRepo extends HibernateUtil<Family> implements CrudRepo<Family>  {

    @Override
    public Family save(Family e) {
        return super.save(e);
    }

    @Override
    public void delete(int id) {
        super.delete(Family.class, id);
    }

    @Override
    public Family findById(int id) {
        return super.find(Family.class, id);
    }

    @Override
    public List<Family> findAll() {
        return super.findAll("Family.findAll");
    }

    public List<Family> findBySalesman(Salesman salesman) {
        Session session = getSession();
        Query myQuery = session.createNamedQuery("Family.findBySalesman").setParameter("salesman", salesman);
        List<Family> family = myQuery.getResultList();
        
        return family;   
    }
    
}
