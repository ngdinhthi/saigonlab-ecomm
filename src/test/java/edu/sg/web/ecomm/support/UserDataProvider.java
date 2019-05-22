package edu.sg.web.ecomm.support;

import edu.sg.web.ecomm.dto.UserLoginDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserDataProvider {

  public UserLoginDto userLogin() {
    UserLoginDto login  = new UserLoginDto();
    login.setUsername("thinguyen");
    login.setEmail("thinguyen@bbv.ch");
    login.setPassword("123");
    login.setHashType("SHA-1");
    login.setActive(true);
    return login;
  }

}
