package com.ilumin.persistence.service;

import com.ilumin.persistence.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SupplierService {

    private HashMap<Integer, Supplier> supplierMap;

    public SupplierService() {
        supplierMap = new HashMap<>();

        // demo supplier
        final Supplier s1 = new Supplier(1, "Samsung", "Samsung co.,ltd.");
        final Supplier s2 = new Supplier(2, "Apple", "Apple co.,ltd.");
        final Supplier s3 = new Supplier(3, "Yikes", "Yikes co.,ltd.");

        supplierMap.put(1, s1);
        supplierMap.put(2, s2);
        supplierMap.put(3, s3);
    }

    public List<Supplier> find() {
        return new ArrayList<>(supplierMap.values());
    }

    public Supplier getById(final Integer supplierId) {
        return supplierMap.get(supplierId);
    }

}
