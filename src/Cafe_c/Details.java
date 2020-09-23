/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cafe_c;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author s
 */
@Entity
@Table(name = "details", catalog = "Cafe", schema = "")
@NamedQueries({
    @NamedQuery(name = "Details.findAll", query = "SELECT d FROM Details d")
    , @NamedQuery(name = "Details.findByTableno", query = "SELECT d FROM Details d WHERE d.tableno = :tableno")
    , @NamedQuery(name = "Details.findByItem1", query = "SELECT d FROM Details d WHERE d.item1 = :item1")
    , @NamedQuery(name = "Details.findByItem2", query = "SELECT d FROM Details d WHERE d.item2 = :item2")
    , @NamedQuery(name = "Details.findByItem3", query = "SELECT d FROM Details d WHERE d.item3 = :item3")})
public class Details implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Table_no")
    private Integer tableno;
    @Basic(optional = false)
    @Column(name = "Item1")
    private String item1;
    @Basic(optional = false)
    @Column(name = "Item2")
    private String item2;
    @Basic(optional = false)
    @Column(name = "Item3")
    private String item3;

    public Details() {
    }

    public Details(Integer tableno) {
        this.tableno = tableno;
    }

    public Details(Integer tableno, String item1, String item2, String item3) {
        this.tableno = tableno;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public Integer getTableno() {
        return tableno;
    }

    public void setTableno(Integer tableno) {
        Integer oldTableno = this.tableno;
        this.tableno = tableno;
        changeSupport.firePropertyChange("tableno", oldTableno, tableno);
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        String oldItem1 = this.item1;
        this.item1 = item1;
        changeSupport.firePropertyChange("item1", oldItem1, item1);
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        String oldItem2 = this.item2;
        this.item2 = item2;
        changeSupport.firePropertyChange("item2", oldItem2, item2);
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        String oldItem3 = this.item3;
        this.item3 = item3;
        changeSupport.firePropertyChange("item3", oldItem3, item3);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableno != null ? tableno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Details)) {
            return false;
        }
        Details other = (Details) object;
        if ((this.tableno == null && other.tableno != null) || (this.tableno != null && !this.tableno.equals(other.tableno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cafe_c.Details[ tableno=" + tableno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
