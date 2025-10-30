package ma.lahjaily.apiserveur;

// Importez les classes depuis leurs NOUVEAUX packages
import ma.lahjaily.apiserveur.entities.Centre;
import ma.lahjaily.apiserveur.entities.Etudiant;
import ma.lahjaily.apiserveur.repositories.CentreRepository;
import ma.lahjaily.apiserveur.repositories.EtudiantRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServeurApplication.class, args);
	}

	/**
	 * Ce Bean s'exécute au démarrage de l'application
	 * et insère des données de test dans la base H2.
	 */
	@Bean
	CommandLineRunner start(CentreRepository centreRepository, EtudiantRepository etudiantRepository) {
		return args -> {
			// 1. Créer et sauvegarder les Centres
			Centre c1 = new Centre();
			c1.setNom_centre("Centre Informatique");
			c1.setAdresse("123 Rue de la Tech");
			centreRepository.save(c1);

			Centre c2 = new Centre();
			c2.setNom_centre("Centre de Langues");
			c2.setAdresse("456 Avenue des Mots");
			centreRepository.save(c2);

			// 2. Créer et sauvegarder des Étudiants en les liant aux centres
			etudiantRepository.save(new Etudiant(null, "Alami", "Ali", "Masculin", c1));
			etudiantRepository.save(new Etudiant(null, "Bennani", "Fatima", "Feminin", c1));
			etudiantRepository.save(new Etudiant(null, "Cherkaoui", "Youssef", "Masculin", c2));

			System.out.println("---- Données initialisées avec succès ! ----");
		};
	}
}