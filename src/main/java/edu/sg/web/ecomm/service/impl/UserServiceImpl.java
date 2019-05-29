package edu.sg.web.ecomm.service.impl;

import edu.sg.web.ecomm.converters.UserLoginConverters;
import edu.sg.web.ecomm.domain.UserInfo;
import edu.sg.web.ecomm.domain.UserLogin;
import edu.sg.web.ecomm.dto.UserLoginDto;
import edu.sg.web.ecomm.repository.UserInfoRepository;
import edu.sg.web.ecomm.repository.UserLoginRepository;
import edu.sg.web.ecomm.service.UserService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserLoginRepository userLoginRepo;
  @Autowired
  private UserInfoRepository userInfoRepo;

  private UserLoginDto user;

  @Override
  @Transactional
  public void registerUser(UserLoginDto user) {
    Assert.notNull(user, "user must not be null");
    UserLogin userLogin = userLoginRepo.save(UserLoginConverters.toNewUserLogin().apply(user));
    List<UserInfo> infos = UserLoginConverters.toUserInfoList(userLogin.getId()).apply(user);
    if (!CollectionUtils.isEmpty(infos)) {
      userInfoRepo.saveAll(infos);
    }
  }

  @Override
  public List<UserLoginDto> searchUsers() {
    return Collections.emptyList();
  }

  @Override
  public Optional<UserLoginDto> login(String username, String password) {
    System.out.println(username);
    System.out.println(password);
    if (StringUtils.isAnyBlank(username, password)) {
      return Optional.empty();
    }
    Optional<UserLoginDto> userOpt = userLoginRepo.findByPasswordAndUsername(password, username)
    .map(userLogin -> {
      UserLoginDto dto = new UserLoginDto();
      BeanUtils.copyProperties(userLogin, dto);
      return dto;
    });
    user = userOpt.orElse(null);
    return Optional.ofNullable(user);
  }

  @Override
  public boolean checkLogin() {
    return user != null;
  }

  @Override
  public Optional<UserLoginDto> getUserLogin() {
    return Optional.of(user);
  }
}
