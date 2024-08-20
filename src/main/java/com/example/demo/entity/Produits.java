package com.example.demo.entity;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;



@Entity
@Table(name="T_Produits")
public class Produits {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nom", length=30)	
    private String nom;
    
    @Column(name="Prix", length=30)	
    private Long Prix;
    
    @Column(name="Quantité", length=30)	
    private Long Quantité;
    
    @Column(name="Code_bard", length=30)	
    private Long Code_bard;
    
    @Column(name="Commentaire", length=30)	
    private String Commentaire;
    
    @Column(name="Entreprise", length=30)	
    private String entreprise;
    
    @Column(name="Lot", length=30)	
    private Long Lot;
    
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
    
    @ManyToOne
    @JoinColumn(name = "id_Produits")
    private Commande Commande;
    
    @ManyToOne
    @JoinColumn(name = "id_Facture")
    private Facture_achat Facture_achat;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getPrix() {
		return Prix;
	}

	public void setPrix(Long prix) {
		Prix = prix;
	}

	public Long getQuantité() {
		return Quantité;
	}

	public void setQuantité(Long quantité) {
		Quantité = quantité;
	}

	public Long getCode_bard() {
		return Code_bard;
	}

	public void setCode_bard(Long code_bard) {
		Code_bard = code_bard;
	}

	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}

	public Long getLot() {
		return Lot;
	}

	public void setLot(Long lot) {
		Lot = lot;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

    
}
