package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.support.ContextIT;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextIT
@Rollback
public class UserInfoRepositoryIT {

  @Autowired
  private UserInfoRepository repository;
}
