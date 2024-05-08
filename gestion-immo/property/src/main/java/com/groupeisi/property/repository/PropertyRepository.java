package com.groupeisi.property.repository;

import com.groupeisi.property.entities.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PropertyRepository extends MongoRepository<Property, String> {
    Optional<Property> findByPersonId(Long personId);
}
