package ma.lahjaily.apiserveur.repositories;

import ma.lahjaily.apiserveur.entities.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CentreRepository extends JpaRepository<Centre, Long> {
}