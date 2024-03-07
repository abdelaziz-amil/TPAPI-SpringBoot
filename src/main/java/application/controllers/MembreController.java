package application.controllers;

import application.dtos.MembreDto;
import application.dtos.MembrePostDto;
import org.springframework.web.bind.annotation.*;

import application.services.impl.MembreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/membres")
public class MembreController {
	
	private final MembreServiceImpl membresService;

	public MembreController(MembreServiceImpl membresService) {
		this.membresService = membresService;
	}

	/**
	 * <p>Get all members in the system</p>
	 * @return List<MembreDto>
	 */
	@GetMapping
	public List<MembreDto> getMembres() {
		return membresService.getAllMembres();
	}

	/**
	 * Method to get the member based on the ID
	 */
	@GetMapping("/{membreId}")
	public MembreDto getMembre(@PathVariable Long membreId){
		return membresService.getMembreById(membreId);
	}

	/**
	 * Create a new Membre in the system
	 */
	@PostMapping
	public MembreDto saveMembre(final @RequestBody MembrePostDto membreDto){
		return membresService.saveMembre(membreDto);
	}

	/**
	 * Delete a member by it's id
	 */
	@DeleteMapping("/{membreId}")
	public Boolean deleteMembre(@PathVariable Long membreId){
		return membresService.deleteMembre(membreId);
	}

	@PutMapping("/{membreId}")
	public MembreDto updateMembre(@PathVariable Long membreId, @RequestBody MembrePostDto membreDto){
		return membresService.updateMembre(membreId, membreDto);
	}
}
