package com.example.test.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel="customer", path= "customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
