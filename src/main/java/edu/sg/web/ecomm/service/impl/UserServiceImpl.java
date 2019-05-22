package edu.sg.web.ecomm.service.impl;

import edu.sg.web.ecomm.dto.UserLoginDto;
import edu.sg.web.ecomm.repository.UserLoginRepository;
import edu.sg.web.ecomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserLoginRepository userLoginRepo;

  @Override
  public void registerUser(UserLoginDto user) {

  }
}
