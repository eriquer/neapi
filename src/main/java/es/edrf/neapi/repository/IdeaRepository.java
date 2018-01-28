package es.edrf.neapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.edrf.neapi.model.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Integer> {

}