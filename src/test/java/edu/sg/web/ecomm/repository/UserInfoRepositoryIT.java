package edu.sg.web.ecomm.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config-test.xml" })
@Rollback
public class UserInfoRepositoryIT {

  @Autowired
  private UserInfoRepository repository;
}
