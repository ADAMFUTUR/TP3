package ma.fsm.hopitaladam.security.entities;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
