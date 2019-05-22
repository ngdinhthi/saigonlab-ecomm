package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.UserLogin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

  Optional<UserLogin> findByPassword(String password);

  Optional<UserLogin> findByUsername(String username);
}
