package ma.lahjaily.clientwebclient.controller;

import ma.lahjaily.clientwebclient.service.EtudiantWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WebClientController {

    @Autowired
    EtudiantWebClient etudiantWebClient;

    @GetMapping("/all")
    public Map getEtudiants() {
        return etudiantWebClient.getEtudiants();
    }

    @DeleteMapping("/supp/{p}")
    public String suppEtudiant(@PathVariable("p") long id) {
        return etudiantWebClient.deleteEtudiant(id);
    }
}