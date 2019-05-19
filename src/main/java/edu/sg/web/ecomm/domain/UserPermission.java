package edu.sg.web.ecomm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_permission")
public class UserPermission implements Serializable {

  private static final long serialVersionUID = 4686925755147818926L;

  private long userId;

  private int permissionId;

  @Column(name = "permission_default")
  private boolean isDefault;
}
