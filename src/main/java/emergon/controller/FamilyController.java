/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.service.FamilyService;
import emergon.service.SalesmanService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Leyteris
 */
@Controller
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @Autowired
    private SalesmanService salesmanService;

    
    @RequestMapping(value = "/salesman/{salesmanId}", method = RequestMethod.GET)
    public String showFamilyBySalesman(@PathVariable(name = "salesmanId") int salesmanId, Model model) {
        Salesman salesman = salesmanService.getSalesman(salesmanId);

        List<Family> family = familyService.findBySalesman(salesman);

        if (family.isEmpty()) {
            model.addAttribute("listOfFamily", null);
        } else {
            model.addAttribute("listOfFamily", family);
        }

        return "family/familyBySalesman";
    }

}
