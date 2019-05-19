package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
