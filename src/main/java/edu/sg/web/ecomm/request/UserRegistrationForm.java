package edu.sg.web.ecomm.request;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserRegistrationForm implements Serializable {

  private String username;

  private String email;

  private String roleCode;
}
