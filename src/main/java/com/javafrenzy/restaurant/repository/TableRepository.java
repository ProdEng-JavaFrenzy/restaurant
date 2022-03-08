package com.javafrenzy.restaurant.repository;

import com.javafrenzy.restaurant.model.Table;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends MongoRepository<Table, String> {
}
