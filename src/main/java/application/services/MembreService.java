package application.services;

import application.dtos.MembreDto;

import java.util.List;

public interface MembreService {
    /**
     * Sauve a member
     */
    MembreDto saveMembre(MembreDto membreDto);

    /**
     * Get a member by it's id
     */
    MembreDto getMembreById(Long membreId);

    /**
     * Delete a member by it's id
     */
    boolean deleteMembre(Long membreId);

    /**
     * Get all the members
     */
    List<MembreDto> getAllMembres();


}
