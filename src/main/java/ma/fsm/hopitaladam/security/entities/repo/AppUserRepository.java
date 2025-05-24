package ma.fsm.hopitaladam.security.entities.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import ma.fsm.hopitaladam.security.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
