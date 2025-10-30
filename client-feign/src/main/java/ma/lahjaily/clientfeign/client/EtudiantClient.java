package ma.lahjaily.clientfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

// Cette annotation dit à Feign :
// "Crée un client REST qui pointe vers http://localhost:8080"
@FeignClient(name = "etudiant-service", url = "http://localhost:8080")
public interface EtudiantClient {

    // "Quand on appelle cette méthode, fais un GET sur /etudiants"
    @GetMapping(value="/etudiants", produces = "application/json")
    Map<String, Object> getAllEtudiants();
}
