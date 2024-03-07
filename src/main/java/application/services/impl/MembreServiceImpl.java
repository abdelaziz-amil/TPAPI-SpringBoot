package application.services.impl;

import application.dtos.MembreDto;
import application.dtos.MembrePostDto;
import application.entities.Membre;
import application.repositories.MembreRepository;
import application.services.MembreService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Service("membresService")
public class MembreServiceImpl {

	private final MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository){
        this.membreRepository = membreRepository;
    }

    public MembreDto saveMembre(MembrePostDto membreDto) {
        // Converts the dto to the membre entity
        Membre membre = membreDtoToEntity(membreDto);
        // Save the membre entity
        membre = membreRepository.save(membre);
        // Return the new dto
        return membreEntityToDto(membre);
    }

    public MembreDto getMembreById(Long membreId) {
        Membre membre = membreRepository.findById(membreId).orElseThrow(() -> new EntityNotFoundException("Membre not found"));
        return membreEntityToDto(membre);
    }

    public boolean deleteMembre(Long membreId) {
        membreRepository.deleteById(membreId);
        return true;
    }

    public List<MembreDto> getAllMembres() {
        List<MembreDto> membreDtos = new ArrayList<>();
        List<Membre> membres = membreRepository.findAll();
        membres.forEach(membre -> membreDtos.add(membreEntityToDto(membre)));
        return membreDtos;
    }

    public MembreDto updateMembre(Long membreId, MembrePostDto membreDto) {
        Membre membre = membreRepository.findById(membreId)
                .orElseThrow(() -> new EntityNotFoundException("Membre not found"));

        // Mettez à jour les champs de l'entité membre avec les valeurs de membreDto
        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenom());
        membre.setDateNaissance(membreDto.getDateNaissance());
        membre.setAdresse(membreDto.getAdresse());
        membre.setEmail(membreDto.getMail());
        membre.setMotDePasse(membreDto.getMotDePasse());

        // Sauvegardez les modifications
        Membre updatedMembre = membreRepository.save(membre);

        // Convertissez l'entité mise à jour en DTO et retournez-le
        return membreEntityToDto(updatedMembre);
    }

    /**
     * Map membre dto to membre entity
     */
    private MembreDto membreEntityToDto(Membre membre){
        MembreDto membreDto = new MembreDto();
        membreDto.setId(membre.getId());
        membreDto.setNom(membre.getNom());
        membreDto.setPrenom(membre.getPrenom());
        membreDto.setDateNaissance(membre.getDateNaissance());
        membreDto.setAdresse(membre.getAdresse());
        membreDto.setMail(membre.getEmail());
        membreDto.setMotDePasse(membre.getMotDePasse());
        return membreDto;
    }

    /**
     * Map member entity to member dto
     */
    private Membre membreDtoToEntity(MembrePostDto membreDto){
        Membre membre = new Membre();
        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenom());
        membre.setDateNaissance(membreDto.getDateNaissance());
        membre.setEmail(membreDto.getMail());
        membre.setAdresse(membreDto.getAdresse());
        membre.setMotDePasse(membreDto.getMotDePasse());
        return membre;
    }
}
