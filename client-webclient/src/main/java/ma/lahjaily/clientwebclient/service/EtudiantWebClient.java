package ma.lahjaily.clientwebclient.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class EtudiantWebClient {

    private final WebClient webClient = WebClient.create("http://localhost:8080");

    private static final String BASE_URL = "http://localhost:8080/etudiants";

    public Map getEtudiants() {
        return webClient.get()
                .uri("/etudiants")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public Map<String, Object> addEtudiant(Map<String, Object> etudiant) {
        try {
            return webClient.post()
                    .uri(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(etudiant)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", "Erreur lors de l'ajout");
        }
    }

    public String deleteEtudiant(Long id) {
        webClient.delete()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .toBodilessEntity()
                .block();

        return "Etudiant: " + id + " deleted";
    }
}