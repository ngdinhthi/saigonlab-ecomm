package edu.sg.web.ecomm.dto;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;

@Data
public class UserLoginDto implements Serializable {

  private static final long serialVersionUID = 610719292839918760L;

  private Long id;

  private String username;

  private String email;

  private String phone;

  private Map<String, String> info;

}
