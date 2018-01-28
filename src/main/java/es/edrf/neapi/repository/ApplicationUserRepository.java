package es.edrf.neapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.edrf.neapi.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}