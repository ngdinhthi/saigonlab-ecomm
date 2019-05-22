package edu.sg.web.ecomm.converters;

import edu.sg.web.ecomm.domain.UserInfo;
import edu.sg.web.ecomm.domain.UserLogin;
import edu.sg.web.ecomm.dto.UserLoginDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import lombok.experimental.UtilityClass;
import org.thymeleaf.util.MapUtils;

@UtilityClass
public class UserLoginConverters {

  public Function<UserLoginDto, UserLogin> toNewUserLogin() {
    return userLoginDto -> {
      UserLogin login = new UserLogin();
      login.setId(userLoginDto.getId());
      login.setUsername(userLoginDto.getUsername());
      login.setEmail(userLoginDto.getEmail());
      login.setPhone(userLoginDto.getPhone());
      login.setPassword(userLoginDto.getPassword());
      login.setHashType(userLoginDto.getHashType());
      login.setActive(userLoginDto.isActive());
      return login;
    };
  }

  public Function<UserLoginDto, List<UserInfo>> toUserInfoList(final Long userId) {
    return userLoginDto -> {
      if (MapUtils.isEmpty(userLoginDto.getInfo())) {
        return Collections.emptyList();
      }
      final List<UserInfo> infoList = new ArrayList<>();
      userLoginDto.getInfo().forEach((key, value) -> {
        UserInfo info = new UserInfo();
        info.setUserId(userId);
        info.setKey(key);
        info.setValue(value);
        infoList.add(info);
      });
      return infoList;
    };
  }

}
