package com.example.demo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="T_Fournisseurs")
public class Fournisseur {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nom", length=30)	
    private String nom;
    
    @Column(name="Prénom", length=30)	
    private String Prénom;
    
    @Column(name="Mail", length=30)	
    private String Mail;
   
    @Column(name="Adrresse_postal", length=30)	
    private String Adrresse_postal;
    
    @Column(name="Numéro_téléphone", length=30)	
    private String Numéro_téléphone;
    
    @Column(name="Identifient_Physcale", length=30)	
    private String Identifient_Physcale;
    
    @OneToMany(mappedBy = "fournisseur")
    private List<Produits> produits;

    @OneToMany(mappedBy = "Fournisseur")
    private List<Facture_achat> Facture_achat;
    
	public Fournisseur(Long id, String nom, List<Produits> produits) {
		super();
		this.id = id;
		this.nom = nom;
		this.produits = produits;
	}

	public Long getId() {
		return id;
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPrénom() {
		return Prénom;
	}

	public void setPrénom(String prénom) {
		Prénom = prénom;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public String getAdrresse_postal() {
		return Adrresse_postal;
	}

	public void setAdrresse_postal(String adrresse_postal) {
		Adrresse_postal = adrresse_postal;
	}

	public String getNuméro_téléphone() {
		return Numéro_téléphone;
	}

	public void setNuméro_téléphone(String numéro_téléphone) {
		Numéro_téléphone = numéro_téléphone;
	}

	public String getIdentifient_Physcale() {
		return Identifient_Physcale;
	}

	public void setIdentifient_Physcale(String identifient_Physcale) {
		Identifient_Physcale = identifient_Physcale;
	}

    
    
}

