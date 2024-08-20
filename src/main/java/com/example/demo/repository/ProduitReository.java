
package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Produits;


public interface ProduitReository  extends CrudRepository<Produits,Long>{

}