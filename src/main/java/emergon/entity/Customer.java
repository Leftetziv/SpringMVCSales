/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leyteris
 */
//@Entity
//@Table(name = "customer")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
//    @NamedQuery(name = "Customer.findByCcode", query = "SELECT c FROM Customer c WHERE c.ccode = :ccode"),
//    @NamedQuery(name = "Customer.findByCname", query = "SELECT c FROM Customer c WHERE c.cname = :cname")})
public class Customer {

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "ccode")
    private Integer ccode;
    
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @Column(name = "cname")
    private String cname;

    public Customer() {
    }

    public Customer(Integer ccode) {
        this.ccode = ccode;
    }

    public Customer(Integer ccode, String cname) {
        this.ccode = ccode;
        this.cname = cname;
    }

    public Integer getCcode() {
        return ccode;
    }

    public void setCcode(Integer ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccode != null ? ccode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.ccode == null && other.ccode != null) || (this.ccode != null && !this.ccode.equals(other.ccode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{ccode=").append(ccode);
        sb.append(", cname=").append(cname);
        sb.append('}');
        return sb.toString();
    }

    
}
