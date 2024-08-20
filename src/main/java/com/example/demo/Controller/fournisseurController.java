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
import com.example.demo.Service.fournisseurService;
import com.example.demo.entity.Fournisseur;


@CrossOrigin("*")
@RestController
@RequestMapping("/fournisseur")
public class fournisseurController {
	
	@Autowired(required=true)
	private fournisseurService ps;

	
	@GetMapping("")
    public List<Fournisseur> getall(){
        return ps.getAllfou();
    }
	
	@PostMapping("/Addfou")
    public Fournisseur addfou(@Validated @RequestBody Fournisseur fou){
       ps.savefou(fou);
        return fou;
    }		
		
	@GetMapping("/getbyid/{id}")
	    public Fournisseur FindByIdprd(@PathVariable Long id){
	        return ps.FindByIdfou(id);
	    }
	
    @DeleteMapping("/deleted/{id}")
		    public void removefout(@PathVariable Long id){
		        ps.DeletefouById(id);
		    }
    
    @PutMapping("/updateFou/{id}")
    public ResponseEntity<Fournisseur> updateProduit(@PathVariable(value = "id") Long id, @Validated @RequestBody Fournisseur updatedProduit) {
        Optional<Fournisseur> optionalProduit = ps.FindByIdfous(id);

        if (optionalProduit.isPresent()) {
        	Fournisseur Fournisseur = optionalProduit.get();

        	Fournisseur.setNom(updatedProduit.getNom());
        	Fournisseur.setPrénom(updatedProduit.getPrénom());
        	Fournisseur.setMail(updatedProduit.getMail());
        	Fournisseur.setAdrresse_postal(updatedProduit.getAdrresse_postal());
        	Fournisseur.setNuméro_téléphone(updatedProduit.getNuméro_téléphone());
        	Fournisseur.setIdentifient_Physcale(updatedProduit.getIdentifient_Physcale());

            Fournisseur updated = ps.savefou(Fournisseur);

            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		
	}