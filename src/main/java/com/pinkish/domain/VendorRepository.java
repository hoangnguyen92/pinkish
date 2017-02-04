package com.pinkish.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {
	Vendor findById(int id);
}