package ma.lahjaily.apiserveur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Centre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_centre; // [cite: 41]
    private String adresse;    // [cite: 41]

    @OneToMany(mappedBy = "centre")
    private List<Etudiant> etudiants;
}
