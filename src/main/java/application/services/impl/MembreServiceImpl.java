package application.services.impl;

import application.dtos.MembreDto;
import application.entities.Membre;
import application.repositories.MembreRepository;
import application.services.MembreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("membresService")
public class MembreServiceImpl implements MembreService {

	private final MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository){
        this.membreRepository = membreRepository;
    }

    @Override
    public MembreDto saveMembre(MembreDto membreDto) {
        // Converts the dto to the membre entity
        Membre membre = membreDtoToEntity(membreDto);
        // Save the membre entity
        membre = membreRepository.save(membre);
        // Return the new dto
        return membreEntityToDto(membre);
    }

    @Override
    public MembreDto getMembreById(Long membreId) {
        Membre membre = membreRepository.findById(membreId).orElseThrow(() -> new EntityNotFoundException("Membre not found"));
        return membreEntityToDto(membre);
    }

    @Override
    public boolean deleteMembre(Long membreId) {
        membreRepository.deleteById(membreId);
        return true;
    }

    @Override
    public List<MembreDto> getAllMembres() {
        List<MembreDto> membreDtos = new ArrayList<>();
        List<Membre> membres = membreRepository.findAll();
        membres.forEach(membre -> {
            membreDtos.add(membreEntityToDto(membre));
        });
        return membreDtos;
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
        membreDto.setEmail(membre.getEmail());
        membreDto.setMotDePasse(membre.getMotDePasse());
        return membreDto;
    }

    /**
     * Map member entity to member dto
     */
    private Membre membreDtoToEntity(MembreDto membreDto){
        Membre membre = new Membre();
        membre.setId(membreDto.getId());
        membre.setNom(membreDto.getNom());
        membre.setPrenom(membreDto.getPrenom());
        membre.setDateNaissance(membreDto.getDateNaissance());
        membre.setEmail(membreDto.getEmail());
        membre.setAdresse(membreDto.getAdresse());
        membre.setMotDePasse(membreDto.getMotDePasse());
        return membre;
    }
}
