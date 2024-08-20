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
import com.example.demo.Service.factureService;
import com.example.demo.entity.Facture_achat;
import com.example.demo.entity.Produits;

@CrossOrigin("*")

@RestController
@RequestMapping("/facture")
public class factureController {
	
	@Autowired(required=true)
	private factureService ps;
 

	
	@GetMapping("")
    public List<Facture_achat> getall(){
        return ps.getAllfact();
    }
	
	@PostMapping("/Addfact")
    public Facture_achat addprd(@Validated @RequestBody Facture_achat fact){
       ps.savefact(fact);
        return fact;
    }		
		
	@GetMapping("/getbyid/{id}")
	    public Facture_achat FindByIdprd(@PathVariable Long id){
	        return ps.FindByIdfact(id);
	    }
	
    @DeleteMapping("/deleted/{id}")
		    public void removefact(@PathVariable Long id){
		        ps.DeletefactById(id);
		    }

    
    @PutMapping("/updatefact/{id}")
    public ResponseEntity<Facture_achat> updateProduit(@PathVariable(value = "id") Long id, @Validated @RequestBody Facture_achat updatedProduit) {
        Optional<Facture_achat> optionalProduit = ps.FindByIdfacts(id);

        if (optionalProduit.isPresent()) {
        	Facture_achat Facture_achat = optionalProduit.get();
        	
        	Facture_achat.setTotal_HT(updatedProduit.getTotal_HT());
        	Facture_achat.setTotal_TVA(updatedProduit.getTotal_TVA());
        	Facture_achat.setTotal_TTC(updatedProduit.getTotal_TTC());
        	Facture_achat.setEntreprise(updatedProduit.getEntreprise());
        	Facture_achat.setQuantité(updatedProduit.getQuantité());
        	
            Facture_achat updated = ps.savefact(Facture_achat);

            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		
	}
