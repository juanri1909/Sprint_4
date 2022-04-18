package cat.itacademy.barcelonactiva.rios.juan.s04.t02.n01_.S04T02N01RiosJuan_.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruita {
	
	
	@Id
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "quilos")
	private int quantitatQuilos;
	
	public Fruita(int id, String nom, int quantitatQuilos) {
		this.id = id;
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}
	
	public Fruita() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}
	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}
		
	@Override
	public String toString() {
		return "id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos;
	}

}