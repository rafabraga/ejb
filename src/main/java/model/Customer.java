package model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = " CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CUSTOMERID", table = "CUSTOMER", unique = true, nullable = false, insertable = true, updatable = true)
    private long customerId;

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "NAME", table = "CUSTOMER")
    private String name;

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
