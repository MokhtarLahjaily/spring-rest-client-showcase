package ma.lahjaily.apiserveur.repositories;

import ma.lahjaily.apiserveur.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    // Ceci crée le point de terminaison : /etudiants/search/findEtudiantByNom?n=...
    @RestResource(path = "findEtudiantByNom")
    List<Etudiant> findEtudiantByNom(@Param("n") String nom); //
}
