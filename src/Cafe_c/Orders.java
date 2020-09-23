/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cafe_c;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author s
 */
@Entity
@Table(name = "orders", catalog = "Cafe", schema = "")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByTableNo", query = "SELECT o FROM Orders o WHERE o.tableNo = :tableNo")
    , @NamedQuery(name = "Orders.findByItemName", query = "SELECT o FROM Orders o WHERE o.itemName = :itemName")
    , @NamedQuery(name = "Orders.findByPrice", query = "SELECT o FROM Orders o WHERE o.price = :price")
    , @NamedQuery(name = "Orders.findByDt", query = "SELECT o FROM Orders o WHERE o.dt = :dt")})
public class Orders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TableNo")
    private int tableNo;
    @Basic(optional = false)
    @Column(name = "ItemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "Price")
    private double price;
    @Basic(optional = false)
    @Column(name = "DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, int tableNo, String itemName, double price, Date dt) {
        this.id = id;
        this.tableNo = tableNo;
        this.itemName = itemName;
        this.price = price;
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        int oldTableNo = this.tableNo;
        this.tableNo = tableNo;
        changeSupport.firePropertyChange("tableNo", oldTableNo, tableNo);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldItemName = this.itemName;
        this.itemName = itemName;
        changeSupport.firePropertyChange("itemName", oldItemName, itemName);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        Date oldDt = this.dt;
        this.dt = dt;
        changeSupport.firePropertyChange("dt", oldDt, dt);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cafe_c.Orders[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
