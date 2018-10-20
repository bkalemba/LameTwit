package pl.bkalemba.lametwit.beans;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bkalemba.lametwit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
