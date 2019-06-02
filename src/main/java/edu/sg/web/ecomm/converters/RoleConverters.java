package edu.sg.web.ecomm.converters;

import edu.sg.web.ecomm.domain.Role;
import edu.sg.web.ecomm.dto.RoleDto;
import java.util.function.Function;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class RoleConverters {

  public Function<Role, RoleDto> roleConverter() {
    return entity -> {
      RoleDto dto = new RoleDto();
      BeanUtils.copyProperties(entity, dto);
      return dto;
    };
  }
}
