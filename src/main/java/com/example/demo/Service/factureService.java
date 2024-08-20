package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Facture_achat;
import com.example.demo.entity.Fournisseur;
import com.example.demo.repository.factureRepository;


@Service
public class factureService {

	@Autowired(required=true)
	private factureRepository ps;
	
		public void removefact(int id) {
			ps.deleteById((long) id);
		}	
		public List<Facture_achat>getAllfact() {
			return (List<Facture_achat>) ps.findAll();
		}
		
		public Facture_achat savefact(Facture_achat fact){
		        return ps.save(fact);
		}
	/**    public Fournisseur FindByIdFour(Long id){
	        return ps.FindByIdFour(id);
	        }*/
		
	    public Facture_achat FindByIdfact(Long id){
        return ps.findById(id).get();
        }
	    public Optional<Facture_achat> FindByIdfacts(Long id){
	        return ps.findById(id);
	    }	 
	    @Transactional
        public List<Facture_achat> findAllfact(){
        return (List<Facture_achat>) ps.findAll();
         }
        
        public void DeletefactById(Long id){
         ps.delete(ps.findById(id).get());
         }

        public Boolean factExiste(Long id){
        return ps.findById(id).get()!=null;
         }


	}