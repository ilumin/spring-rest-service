package com.ilumin.persistence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.hateoas.ResourceSupport;

@JsonInclude(Include.NON_NULL)
public class Supplier extends ResourceSupport {

    private Integer supplierId;
    private String supplierName;
    private String companyName;

    public Supplier() {
        super();
    }

    public Supplier(final Integer id, final String name, final String companyName) {
        setSupplierId(id);
        setName(name);
        setCompanyName(companyName);
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return supplierName;
    }

    public void setName(String name) {
        this.supplierName = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
