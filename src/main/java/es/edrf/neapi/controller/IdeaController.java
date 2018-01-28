package es.edrf.neapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.edrf.neapi.model.Idea;
import es.edrf.neapi.repository.IdeaRepository;

@RestController
@RequestMapping("/api")
public class IdeaController {

	@Autowired
    IdeaRepository ideaRepository;

	public IdeaController() {
	}

	@GetMapping("/ideas")
	public List<Idea> getAllIdeas() {
	    return ideaRepository.findAll();
	}
	
	@PostMapping("/ideas")
	public Idea createIdea(@Valid @RequestBody Idea idea) {
	    return ideaRepository.save(idea);
	}
	
	@GetMapping("/ideas/{id}")
	public ResponseEntity<Idea> getIdeaById(@PathVariable(value = "id") Integer ideaId) {
	    Idea idea = ideaRepository.findOne(ideaId);
	    if(idea == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(idea);
	}
	
	@PutMapping("/ideas/{id}")
	public ResponseEntity<Idea> updateNote(@PathVariable(value = "id") Integer ideaId, @Valid @RequestBody Idea ideaDetails) {
	    Idea idea = ideaRepository.findOne(ideaId);
	    if(idea == null) {
	        return ResponseEntity.notFound().build();
	    }
	    idea.setTitle(ideaDetails.getTitle());
	    idea.setContent(ideaDetails.getContent());

	    Idea updatedIdea = ideaRepository.save(idea);
	    return ResponseEntity.ok(updatedIdea);
	}

	@DeleteMapping("/ideas/{id}")
	public ResponseEntity<Idea> deleteNote(@PathVariable(value = "id") Integer ideaId) {
		Idea idea = ideaRepository.findOne(ideaId);
	    if(idea == null) {
	        return ResponseEntity.notFound().build();
	    }

	    ideaRepository.delete(idea);
	    return ResponseEntity.ok().build();
	}
	
}
