package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Clients;
import com.example.demo.repository.ClientRepository;

@Service
public class Clientservice {

	@Autowired(required=true)
	private ClientRepository ps;
		
		public Clients  saveCL(Clients p){
		        return ps.save(p);
		}
		public Clients FindByIdCLs(Long id){
        return ps.findById(id).get();
       }
		
	    public Optional<Clients> FindByIdCL(Long id){
	        return ps.findById(id);
	    }	  

		public void deleteCL(Clients p){
		    ps.delete(p);
		}
		
		public List<Clients> getAllCL() {
			// TODO Auto-generated method stub
			return (List<Clients>) ps.findAll();
		}	
		
		@Transactional
	    public List<Clients> findAllCL(){
	        return (List<Clients>) ps.findAll();
	    }
	    public void DeleteCLById(Long id){
	       ps.delete(ps.findById(id).get());
	    }

	    public Boolean CLExiste(Long id){
	        return ps.findById(id).get()!=null;
	    }


	}