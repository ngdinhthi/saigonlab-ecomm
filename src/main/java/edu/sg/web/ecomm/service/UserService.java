package edu.sg.web.ecomm.service;

import edu.sg.web.ecomm.domain.UserLogin;
import edu.sg.web.ecomm.dto.UserLoginDto;
import java.util.List;
import java.util.Optional;

public interface UserService {

  void registerUser(UserLoginDto user);

  List<UserLoginDto> searchUsers();

  Optional<UserLoginDto> login(String username, String password);

  boolean checkLogin();

  Optional<UserLoginDto> getUserLogin();
}
