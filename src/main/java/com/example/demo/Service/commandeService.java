package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Commande;
import com.example.demo.repository.CommandeRepository;


@Service
public class commandeService {

	@Autowired(required=true)
	private CommandeRepository ps;
		
		public void removeCom(int id) {
			ps.deleteById((long) id);
		}
		
		public List<Commande> getAllCom() {
			return (List<Commande>) ps.findAll();
		}
		
		public Commande saveCom(Commande Com){
		        return ps.save(Com);
		}
		   public Optional<Commande> FindByIdComms(Long id){
		        return ps.findById(id);
		    }	 
	    public Commande FindByIdComm(Long id){
        return ps.findById(id).get();
        }
	
	    @Transactional
        public List<Commande> findAllComm(){
        return (List<Commande>) ps.findAll();
         }
        
        public void DeleteCommById(Long id){
         ps.delete(ps.findById(id).get());
         }

        public Boolean CommExiste(Long id){
        return ps.findById(id).get()!=null;
         }

	}