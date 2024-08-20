package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Commande;

public interface CommandeRepository extends  CrudRepository<Commande,Long>{
}
