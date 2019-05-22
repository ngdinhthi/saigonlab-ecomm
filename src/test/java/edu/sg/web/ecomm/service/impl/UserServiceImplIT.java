package edu.sg.web.ecomm.service.impl;

import edu.sg.web.ecomm.dto.UserLoginDto;
import edu.sg.web.ecomm.service.UserService;
import edu.sg.web.ecomm.support.ContextIT;
import edu.sg.web.ecomm.support.UserDataProvider;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextIT
@Transactional
public class UserServiceImplIT {

  @Autowired
  private UserService service;

  @Test
  public void testRegisterUser() {
    final UserLoginDto login = UserDataProvider.userLogin();
    service.registerUser(login);
  }

}
