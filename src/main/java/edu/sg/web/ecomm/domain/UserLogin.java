package edu.sg.web.ecomm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable {

  private static final long serialVersionUID = -3074924826644002793L;

  @Id
  @GeneratedValue
  private Long id;

  private String username;

  private String email;

  private String phone;

  private String password;

  private String hashType;

  private boolean active;
}
