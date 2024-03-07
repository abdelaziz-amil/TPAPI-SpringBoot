package application.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MembrePostDto {

  private String nom;
  private String prenom;
  private String adresse;
  private LocalDate dateNaissance;
  private String mail;
  private String motDePasse;

}
