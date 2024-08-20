package com.example.demo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Facture_achat")
public class Facture_achat {


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Fact_Achat;
        
    @Column(name="Total_HT",length=30)
	private Double Total_HT;

    @Column(name="Total_TVA",length=30)
	private Double Total_TVA;

    @Column(name="Total_TCC",length=30)
	private Double Total_TTC;
    
    @Column(name="Quantité",length=30)
  	private Long Quantité;
    
    @Column(name="Entreprise", length=30)	
    private String entreprise;
    
    @OneToMany(mappedBy = "Facture_achat")
    private List<Produits> Produits;
    
    @ManyToOne
    @JoinColumn(name = "id_fr")
    private Fournisseur Fournisseur;
 
    

	public Long getId_Fact_Achat() {
		return id_Fact_Achat;
	}




	public void setId_Fact_Achat(Long id_Fact_Achat) {
		this.id_Fact_Achat = id_Fact_Achat;
	}




	public Double getTotal_HT() {
		return Total_HT;
	}




	public String getEntreprise() {
		return entreprise;
	}




	public Long getQuantité() {
		return Quantité;
	}




	public void setQuantité(Long quantité) {
		Quantité = quantité;
	}




	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}




	public void setTotal_HT(Double total_HT) {
		Total_HT = total_HT;
	}




	public Double getTotal_TVA() {
		return Total_TVA;
	}




	public void setTotal_TVA(Double total_TVA) {
		Total_TVA = total_TVA;
	}




	public Double getTotal_TTC() {
		return Total_TTC;
	}




	public void setTotal_TTC(Double total_TTC) {
		Total_TTC = total_TTC;
	}



		
	public Facture_achat() {
		super();
		// TODO Auto-generated constructor stub
	}
}