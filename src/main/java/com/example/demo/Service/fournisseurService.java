package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fournisseur;
import com.example.demo.repository.fournisseurRepository;

@Service
public class fournisseurService {

	@Autowired(required=true)
	private fournisseurRepository ps;
		
		public void removefou(int id) {
			ps.deleteById((long) id);
		}
		
		public List<Fournisseur>getAllfou() {
			// TODO Auto-generated method stub
			return (List<Fournisseur>) ps.findAll();
		}
		
		public Fournisseur savefou(Fournisseur fou){
		        return ps.save(fou);
		}
	    public Optional<Fournisseur> FindByIdfous(Long id){
	        return ps.findById(id);
	    }	 
		
	    public Fournisseur FindByIdfou(Long id){
        return ps.findById(id).get();
        }
	
	    @Transactional
        public List<Fournisseur> findAllfou(){
        return (List<Fournisseur>) ps.findAll();
         }
        
        public void DeletefouById(Long id){
         ps.delete(ps.findById(id).get());
         }

        public Boolean fouExiste(Long id){
        return ps.findById(id).get()!=null;
         }


	}