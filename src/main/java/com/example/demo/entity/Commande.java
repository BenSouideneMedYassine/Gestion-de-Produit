package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Comm ;
    
    @Column(name="QuantiteFourni",length=30)
    private int QuantiteFourni;
 


    @OneToMany(mappedBy = "Commande")
    private List<Produits> Produits;

    @ManyToOne
    @JoinColumn(name = "id_Clients")
    private Clients Clients;

	public Long getId_Comm() {
		return id_Comm;
	}

	public void setId_Comm(Long id_Comm) {
		this.id_Comm = id_Comm;
	}

	public int getQuantiteFourni() {
		return QuantiteFourni;
	}

	public void setQuantiteFourni(int quantiteFourni) {
		QuantiteFourni = quantiteFourni;
	}


	
    
    
}
