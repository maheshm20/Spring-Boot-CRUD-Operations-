package com.spring.rest_api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest_api.Entity.Products;

@Repository
public interface ProductCrud extends JpaRepository<Products, Long> {

}
