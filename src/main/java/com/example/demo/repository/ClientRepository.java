package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long> {
}
