package edu.sg.web.ecomm.service.impl;

import edu.sg.web.ecomm.converters.UserLoginConverters;
import edu.sg.web.ecomm.domain.UserInfo;
import edu.sg.web.ecomm.domain.UserLogin;
import edu.sg.web.ecomm.dto.UserLoginDto;
import edu.sg.web.ecomm.repository.UserInfoRepository;
import edu.sg.web.ecomm.repository.UserLoginRepository;
import edu.sg.web.ecomm.service.UserService;
import java.util.List;
import javax.transaction.Transactional;
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
}
