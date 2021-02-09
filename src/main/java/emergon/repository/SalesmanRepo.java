/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Product;
import emergon.entity.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leyteris
 */
@Repository
public class SalesmanRepo extends HibernateUtil<Salesman> implements CrudRepo<Salesman> {

    @Override
    public void delete(int id) {
        super.delete(Salesman.class, id);
    }

    @Override
    public Salesman findById(int id) {
        return super.find(Salesman.class, id);
    }

    @Override
    public List<Salesman> findAll() {
        return super.findAll("Salesman.findAll");
    }

    @Override
    public Salesman save(Salesman s) {
        return super.save(s);
    }

}
