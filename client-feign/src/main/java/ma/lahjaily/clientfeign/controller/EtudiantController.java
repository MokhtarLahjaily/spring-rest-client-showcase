package ma.lahjaily.clientfeign.controller;

import ma.lahjaily.clientfeign.client.EtudiantClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EtudiantController {

    EtudiantClient etudiantClient; //

    // Injection via le constructeur
    public EtudiantController(EtudiantClient etudiantClient) {
        this.etudiantClient = etudiantClient;
    }

    @GetMapping("/api/etudiants")
    public List<Map<String, Object>> getAllEtudiants() {
        Map<String, Object> response = etudiantClient.getAllEtudiants();

        Map<String, Object> embedded = (Map<String, Object>) response.get("_embedded");
        List<Map<String, Object>> etudiantsData = (List<Map<String, Object>>) embedded.get("etudiants");

        return etudiantsData;
    }
}