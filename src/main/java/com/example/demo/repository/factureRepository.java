package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Facture_achat;

public interface factureRepository  extends CrudRepository<Facture_achat,Long>{
	
	
   /** @Query(value = "select * from t_fournisseur where id_fr =idU",nativeQuery = true)
   public Fournisseur FindByIdFour(@Param(value ="idU") Long idU);  */  

}