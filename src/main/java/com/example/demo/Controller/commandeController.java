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
import com.example.demo.Service.commandeService;
import com.example.demo.entity.Commande;



@CrossOrigin("*")
@RestController
@RequestMapping("/commande")
public class commandeController {
	
	@Autowired(required=true)
	private commandeService ps;
 
	
	@GetMapping("")
    public List<Commande> getall(){
        return ps.getAllCom();
    }

	@GetMapping("/getbyid/{id}")
    public Commande FindByIdCom(@PathVariable Long id){
        return ps.FindByIdComm(id);
    }
	
	@PostMapping("/Addcom")
    public Commande addfou(@Validated @RequestBody Commande Com){
        return ps.saveCom(Com);
    }		
	
    @DeleteMapping("/deleted/{id}")
		    public void removecomm(@PathVariable Long id){
		        ps.DeleteCommById(id);
		    }
    
    @PutMapping("/updateCommande/{id}")
    public ResponseEntity<Commande> updateProduit(@PathVariable(value = "id") Long id, @Validated @RequestBody Commande updatedProduit) {
        Optional<Commande> optionalProduit = ps.FindByIdComms(id);

        if (optionalProduit.isPresent()) {
        	Commande Commande = optionalProduit.get();

        	Commande.setQuantiteFourni(updatedProduit.getQuantiteFourni());

            Commande updated = ps.saveCom(Commande);

            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
