package ma.fsm.hopitaladam.security.entities.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.fsm.hopitaladam.security.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {

}