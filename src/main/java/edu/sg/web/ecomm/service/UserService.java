package edu.sg.web.ecomm.service;

import edu.sg.web.ecomm.dto.UserLoginDto;

public interface UserService {

  void registerUser(UserLoginDto user);
}
