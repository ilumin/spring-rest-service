package com.ilumin.rest.controller;

import com.google.common.base.Preconditions;
import com.ilumin.persistence.model.Supplier;
import com.ilumin.persistence.service.SupplierService;
import com.ilumin.rest.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping( value = "/suppliers" )
public class SupplierController {

    @Autowired
    private SupplierService service;

    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public List<Supplier> find() {
        final List<Supplier> suppliers = service.find();

        // modified data for HATEOAS
        for (final Supplier supplier: suppliers) {
            Integer supplierId = supplier.getSupplierId();
            Link selfLink = linkTo(SupplierController.class).slash(supplierId).withSelfRel();
            supplier.add(selfLink);
        }

        return suppliers;
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ResponseBody
    public Supplier get(@PathVariable("id") Integer id) {
        return RestPreconditions.checkFound(service.getById(id));
    }

}
