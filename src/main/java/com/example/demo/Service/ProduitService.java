package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Produits;
import com.example.demo.repository.ProduitReository;

@Service
public class ProduitService {

	@Autowired(required=true)
	private ProduitReository ps;

		public void removeprd(int id) {
			ps.deleteById((long) id);
		}	
		public List<Produits> getAllProduits() {
			return (List<Produits>) ps.findAll();
		}
		
		
		
	    public Produits FindByIdprd(Long id){
        return ps.findById(id).get();
        }
	    public Produits saveprd(Produits p){
	        return ps.save(p);
	}
	/******************************************************************/
	    public Optional<Produits> FindByIdprds(Long id){
	        return ps.findById(id);
	    }	  

		public void deleteprd(Produits p){
		    ps.delete(p);
		}
	/********************************************************************/
	    @Transactional
        public List<Produits> findAllprd(){
        return (List<Produits>) ps.findAll();
         }
        public void DeleteprdById(Long id){
         ps.delete(ps.findById(id).get());
         }

        public Boolean prdExiste(Long id){
        return ps.findById(id).get()!=null;
         }
        
      /*  public static <T> Predicate<T> myIsEqual(Object targetRef) {
            Predicate<T> tester = obj -> Objects.equals(obj, targetRef);
            return tester;
        }
        static <T> Predicate<T> isEqual(Object targetRef) {
            return (null == targetRef)
                    ? Objects::isNull
                    : object -> targetRef.equals(object);
        }
        public List<ProduitPharmacetique> Findsprds(String libpr){
        	Predicate<ProduitPharmacetique> test1 = Predicate.isEqual(libpr); 
        	 Predicate<ProduitPharmacetique> tester2 = name -> name.equals(libpr);
      	Predicate<? super ProduitPharmacetique> test2 = Predicate.isEqual(libpr); 
        	 return ProduitPharmacetique.stream()
        			    .filter(test1.and(tester2)).collect(Collectors.toList());
        }*/
	       
	}