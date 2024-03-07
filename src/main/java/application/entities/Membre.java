package application.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "membre")
public class Membre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "dateNaissance")
	private LocalDate dateNaissance;
	@Column(name = "email")
	private String email;
	@Column(name = "motDePasse")
	private String motDePasse;
	
}
