package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
}
