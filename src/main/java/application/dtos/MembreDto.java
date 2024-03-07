package application.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MembreDto {

	private Long Id;
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate dateNaissance;
	private String email;
	private String motDePasse;

}
