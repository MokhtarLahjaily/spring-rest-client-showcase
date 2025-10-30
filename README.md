# Spring REST Client Showcase

Ce projet est une démonstration technique des différentes façons de consommer des services web RESTful dans l'écosystème Spring Boot. Il compare trois approches client (`RestTemplate`, `WebClient`, `Feign`) qui interagissent avec une API centrale.

## Table des Matières
1. [Structure du Projet](#structure-du-projet)
2. [Stack Technique](#stack-technique)
3. [Description des Modules](#description-des-modules)
4. [Démarrage Rapide (Getting Started)](#démarrage-rapide-getting-started)
5. [Endpoints de Test](#endpoints-de-test)
6. [Contribuer](#contribuer)
7. [Licence](#licence)

## Structure du Projet

Le projet est structuré comme un projet Maven multi-module :

- **`api-serveur`** : Le serveur API REST principal (basé sur Spring Data REST).
- **`client-rest-template`** : Implémentation client avec `RestTemplate` (synchrone).
- **`client-webclient`** : Implémentation client avec `WebClient` (réactif).
- **`client-feign`** : Implémentation client avec `Spring Cloud OpenFeign` (déclaratif).

## Stack Technique

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Cloud 2025.0.0**
- **Maven**
- **API Serveur :**
  - `Spring Data REST`
  - `Spring Data JPA`
  - `H2 Database`
- **Clients :**
  - `Spring Web`
  - `Spring WebFlux`
  - `Spring Cloud OpenFeign`

## Description des Modules

### 1. `api-serveur` (Port 8080)
Application Spring Boot au cœur du projet. Elle expose automatiquement une API REST pour les entités `Etudiant` et `Centre` via Spring Data REST. La base de données H2 en mémoire est pré-remplie au démarrage.

### 2. `client-rest-template` (Port 8081)
Démontre l'approche traditionnelle et synchrone pour consommer l'API à l'aide de `RestTemplate`.

### 3. `client-webclient` (Port 8082)
Illustre l'approche moderne réactive en utilisant `WebClient` de Spring WebFlux.

### 4. `client-feign` (Port 8083)
Met en avant l'approche déclarative de `Spring Cloud OpenFeign`, qui génère l'implémentation du client à partir d'une interface Java annotée.

## Démarrage Rapide (Getting Started)

Les trois clients dépendent du module `api-serveur`. Assurez-vous de lancer le serveur en premier.

### Prérequis

- Java 21 (JDK)
- Maven 3.6+

### Méthode 1 : Ligne de commande

```bash
git clone https://github.com/MokhtarLahjaily/spring-rest-client-showcase
cd spring-rest-client-showcase
mvn clean install
```

Ouvrez ensuite **quatre** terminaux distincts :

```bash
# Terminal 1 (serveur) - à démarrer en premier
mvn spring-boot:run -pl api-serveur

# Terminal 2 (client RestTemplate)
mvn spring-boot:run -pl client-rest-template

# Terminal 3 (client WebClient)
mvn spring-boot:run -pl client-webclient

# Terminal 4 (client Feign)
mvn spring-boot:run -pl client-feign
```

### Méthode 2 : IDE

1. Importez le projet parent `TpDataRest` dans votre IDE (IntelliJ, Eclipse, VS Code).
2. Lancez successivement les méthodes `main` suivantes :
   - `ApiServeurApplication`
   - `ClientRestTemplateApplication`
   - `ClientWebclientApplication`
   - `ClientFeignApplication`

## Endpoints de Test

Une fois les 4 applications démarrées, chaque endpoint renvoie la même liste d'étudiants :

- **Serveur (source de données)** : `http://localhost:8080/etudiants`
- **Client RestTemplate** : `http://localhost:8081/client/rest`
- **Client WebClient** : `http://localhost:8082/all`
- **Client Feign** : `http://localhost:8083/api/etudiants`

### Exemple de réponse JSON

```json
[
  {
    "nom": "Alami",
    "prenom": "Ali",
    "genre": "Masculin",
    "_links": {
      "self": { "href": "http://localhost:8080/etudiants/1" },
      "etudiant": { "href": "http://localhost:8080/etudiants/1" },
      "centre": { "href": "http://localhost:8080/etudiants/1/centre" }
    }
  }
]
```

## Contribuer

1. Forkez le dépôt.
2. Créez votre branche (`git checkout -b feature/NouvelleFeature`).
3. Commitez vos changements (`git commit -m 'Ajout de NouvelleFeature'`).
4. Pushez votre branche (`git push origin feature/NouvelleFeature`).
5. Ouvrez une Pull Request.

## Licence

Ce projet est distribué sous licence MIT. Consultez le fichier [`LICENSE.txt`](LICENSE.txt) pour plus de détails.
