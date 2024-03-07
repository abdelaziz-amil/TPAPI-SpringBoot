package application.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MembrePostDto {

  private String nom;
  private String prenom;
  private String adresse;
  private LocalDateTime dateNaissance;
  private String mail;
  private String motDePasse;

}
