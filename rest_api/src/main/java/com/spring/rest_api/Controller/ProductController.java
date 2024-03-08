package com.spring.rest_api.Controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest_api.Entity.Products;
import com.spring.rest_api.Repo.ProductCrud;

//@CrossOrigin("*")
@RestController
public class ProductController {
	
	private final ProductCrud productcrud;

    public ProductController(ProductCrud productcrud) {
        this.productcrud = productcrud;
    }
    
    @PostMapping("/users")
    public Products createUser(@RequestBody Products products) {
        return productcrud.save(products);
    }

  @GetMapping("/users")
   public List<Products> getAllUsers() {
      return productcrud.findAll();
   }

    @GetMapping("/users/{id}")
  public Products getUserById(@PathVariable Long id) {
      return productcrud.findById(id).orElseThrow();
      }

 @PutMapping("/users/{id}")
  public Products updateUser(@PathVariable Long id, @RequestBody Products user) {
  	Products existingUser = productcrud.findById(id).orElseThrow();
  	existingUser.setName(user.getName());
       existingUser.setPrice(user.getPrice());
        return productcrud.save(existingUser);
    }

  @DeleteMapping("/users/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Long id) {
   	productcrud.deleteById(id);
       return ResponseEntity.ok().build();
  	}
}
