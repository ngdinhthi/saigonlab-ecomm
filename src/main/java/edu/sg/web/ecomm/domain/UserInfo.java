package edu.sg.web.ecomm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

  private static final long serialVersionUID = -1467049699901914936L;

  @Id
  private long userId;

  private String key;

  private String value;

}
