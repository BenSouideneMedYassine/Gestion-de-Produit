package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.Clientservice;
import com.example.demo.entity.Clients;

import ch.qos.logback.core.net.server.Client;


@CrossOrigin("*")
@RestController
@RequestMapping("/Clients")
public class Clientcontroller {
	
	@Autowired(required=true)
	private Clientservice ps;
	
	@GetMapping("")
    public List<Clients> getall(){
        return ps.getAllCL();
    }
	
	@GetMapping("/getbyid/{id}")
    public Clients FindByIdfam(@PathVariable Long id){
        return ps.FindByIdCLs(id);
    }
	
	@PostMapping("/Addfam")
    public Clients addfam(@Validated @RequestBody Clients p){
       ps.saveCL(p);
        return p;
    }
	 @DeleteMapping("/deletefam/{id}")
	 public ResponseEntity<?> deletefam(@PathVariable Long id) {
	     Optional<Clients> optionalClient = ps.FindByIdCL(id);
	     if (optionalClient.isPresent()) {
	         ps.deleteCL(optionalClient.get());
	         return ResponseEntity.ok().body("Le client avec l'id " + id + " a été supprimé.");
	     } else {
	         System.out.println("Il n'y a aucun client existant avec l'id " + id);
	         return ResponseEntity.notFound().build();
	     }
	 }

	  @PutMapping("/updatefam/{id}")
	    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Clients updatedClient) {
	        Optional<Clients> optionalClient = ps.FindByIdCL(id);
	        if (optionalClient.isPresent()) {
	        	
	            Clients existingClient = optionalClient.get();
	            
	            existingClient.setNom(updatedClient.getNom());
	            existingClient.setPrénom(updatedClient.getPrénom());
	        	existingClient.setMail(updatedClient.getMail());
	        	existingClient.setAdrresse_postal(updatedClient.getAdrresse_postal());
	        	existingClient.setNuméro_téléphone(updatedClient.getNuméro_téléphone());
	        	existingClient.setIdentifient_Physcale(updatedClient.getIdentifient_Physcale());
	        	
	            Clients savedClient = ps.saveCL(existingClient);
	            return ResponseEntity.ok().body(savedClient);
	        } else {
	            System.out.println("Il n'y a aucun client existant avec l'id " + id);
	            return ResponseEntity.notFound().build();
	        }
	    }
	
}