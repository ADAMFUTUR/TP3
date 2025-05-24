# Gestion des Patients - Hôpital Adam

## Description du Projet
Ce projet est une application web de gestion des patients développée avec Spring Boot. Elle permet la gestion complète des patients d'un hôpital avec un système d'authentification et d'autorisation.

## Fonctionnalités
- Authentification des utilisateurs (login/logout)
- Gestion des rôles (ADMIN, USER)
- CRUD des patients :
  - Affichage paginé des patients
  - Recherche de patients
  - Ajout de nouveaux patients (ADMIN)
  - Modification des informations (ADMIN)
  - Suppression de patients (ADMIN)

## Technologies Utilisées
- Spring Boot 3.4.5
- Spring Security
- Spring Data JPA
- Thymeleaf
- H2 Database
- Bootstrap 5.3.5
- Lombok

## Structure du Projet

### Entités
1. **Patient**
```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
```

2. **AppUser et AppRole** (Sécurité)
```java
@Entity
public class AppUser {
    @Id
    private String userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;
}

@Entity
public class AppRole {
    @Id
    private String role;
}
```

### Services
- **PatientService** : Gestion des opérations CRUD pour les patients
- **AccountService** : Gestion des utilisateurs et des rôles

### Contrôleurs
1. **PatientController** : Gestion des routes pour les patients
   - `/user/index` : Liste des patients
   - `/admin/delete` : Suppression (ADMIN)
   - `/admin/formPatients` : Formulaire d'ajout (ADMIN)
   - `/admin/save` : Sauvegarde (ADMIN)
   - `/admin/editPatient` : Modification (ADMIN)

2. **SecurityController** : Gestion de l'authentification
   - `/login` : Page de connexion
   - `/notAuthorized` : Page d'erreur d'autorisation

## Interface Utilisateur
- Design responsive avec Bootstrap
- Navigation avec barre de menu
- Formulaires de saisie validés
- Messages de confirmation
- Pagination des résultats
- Barre de recherche

## Sécurité
- Authentification basée sur Spring Security
- Gestion des rôles (ADMIN, USER)
- Protection des routes sensibles
- Encodage des mots de passe avec BCrypt

## Base de Données
- Utilisation de H2 (base de données en mémoire)
- Support pour MySQL configuré
- Mapping ORM avec JPA/Hibernate

## Configuration
```properties
spring.application.name=HopitalAdam
server.port=8088
spring.datasource.url=jdbc:h2:mem:patients-db
```

## Tests
Le projet inclut une classe de test de base :
```java
@SpringBootTest
class HopitalAdamApplicationTests {
    @Test
    void contextLoads() {
    }
}
```

## Démarrage
Pour lancer l'application :
1. Cloner le projet
2. Exécuter `./mvnw spring-boot:run`
3. Accéder à `http://localhost:8088`