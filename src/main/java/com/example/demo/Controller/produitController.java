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

import com.example.demo.entity.Clients;
import com.example.demo.entity.Produits;
import com.example.demo.Service.ProduitService;

@CrossOrigin("*")
@RestController
@RequestMapping("/produits")
public class produitController {
	
	@Autowired(required=true)
	private ProduitService ps;

	
	@GetMapping("")
    public List<Produits> getall(){
        return ps.getAllProduits();
    }
	
	@PostMapping("/Addprd")
    public Produits addprd(@Validated @RequestBody Produits p){
       ps.saveprd(p);
        return p;
    }		
		
	@GetMapping("/getbyid/{id}")
	    public Produits FindByIdprd(@PathVariable Long id){
	        return ps.FindByIdprd(id);
	    }
	
    @DeleteMapping("/deleted/{id}")
		    public void removeprd(@PathVariable Long id){
		        ps.DeleteprdById(id);
		    }

   @PutMapping("/updateProduit/{id}")
   public ResponseEntity<Produits> updateProduit(@PathVariable(value = "id") Long id, @Validated @RequestBody Produits updatedProduit) {
       Optional<Produits> optionalProduit = ps.FindByIdprds(id);

       if (optionalProduit.isPresent()) {
           Produits produit = optionalProduit.get();

           produit.setNom(updatedProduit.getNom());
           produit.setPrix(updatedProduit.getPrix());
           produit.setQuantité(updatedProduit.getQuantité());
           produit.setCommentaire(updatedProduit.getCommentaire());
           produit.setEntreprise(updatedProduit.getEntreprise());
           produit.setLot(updatedProduit.getLot());

           Produits updated = ps.saveprd(produit);

           return ResponseEntity.ok().body(updated);
       } else {
           return ResponseEntity.notFound().build();
       }
   }

		
	}
