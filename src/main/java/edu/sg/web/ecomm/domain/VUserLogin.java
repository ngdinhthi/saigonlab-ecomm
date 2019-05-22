package edu.sg.web.ecomm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "v_user_login")
public class VUserLogin implements Serializable {

  private static final long serialVersionUID = -3074924826644002792L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "username")
  private String name;

  private String email;

  private String phone;

  private String password;

  @Column(name = "hash_type")
  private String hashType;

  private boolean active;
}
